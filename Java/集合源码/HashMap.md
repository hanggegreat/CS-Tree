`HashMap`允许空值和空键。它的方法是不同步的。

``` java
package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import sun.misc.SharedSecrets;

public class HashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {

    private static final long serialVersionUID = 362498820763181265L;
	
	// 默认初始容量为16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    // 最大容量为 2^31
    static final int MAXIMUM_CAPACITY = 1 << 30;

    // 默认负载因子，当 "容量 * 负载因子 < 保存节点个数" 时发生扩容。
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // 树化阈值，为8，根据泊松分布计算得来。
    // 一个桶中节点到达8个的概率为0.00000006，这几乎是不可能的事情
    // 由于红黑树比链表占用的空间大，所以为了节省空间，当桶节点个数小于8时使用链表，到达8个树化。
    // 8个节点的红黑树平均查找时间为log8，即3，而链表为8/2，即4 > 3。这可能也是一个原因。
    static final int TREEIFY_THRESHOLD = 8;

    // 当桶中节点个数降到6个时，将红黑树变为链表。
    // 还有选择6和8，中间有个差值7可以有效防止链表和树频繁转换。
    static final int UNTREEIFY_THRESHOLD = 6;

    
    // 这个字段决定了当hash表至少为多大时，链表才能进行树化。这个设计是合理的
    // 当hash表中保存的元素个数少于64时，很有可能是因为容量过小导致的hash冲突
    // 这时进行一次扩容操作基本上就能解决冲突问题
    static final int MIN_TREEIFY_CAPACITY = 64;

    // 哈希表中实际存储的节点类型
    static class Node<K,V> implements Map.Entry<K,V> {
    	// hash值，用来计算节点所在桶的位置
        final int hash;
        // 键
        final K key;
        // 值
        V value;
        // 链表下一个节点，用于解决hash冲突
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

    // 计算节点hash值，(h = key.hashCode()) ^ (h >>> 16)
    // hashcode的高16位和低16位都参与运算，会让得到的下标更加散列。
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    // 得到要扩容阈值，即第一个大于cap的2的幂。
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    // 实际存储数据的数组
    transient Node<K,V>[] table;

    // Map.Entry集合
    transient Set<Map.Entry<K,V>> entrySet;

    // 当前的键值对个数
    transient int size;

    // 每次进行更新操作都需要加1，用于判断在这期间是否有其他的线程进行修改操作。
    transient int modCount;

    // 需要进行扩容的阈值
    int threshold;

    // 负载因子
    final float loadFactor;

    // 指定初始容量和负载因子的构造方法
    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    // 指定初始容量的构造方法，默认负载因子为0.75
    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    // 无参构造，默认负载因子为0.75
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }

    // 将其他Map实例转化为HashMap
    public HashMap(Map<? extends K, ? extends V> m) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(m, false);
    }

    // 将其他Map实例中的键值对添加到当前HashMap实例
    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
        int s = m.size();
        if (s > 0) {
            if (table == null) { // pre-size
                float ft = ((float)s / loadFactor) + 1.0F;
                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                         (int)ft : MAXIMUM_CAPACITY);
                if (t > threshold)
                    threshold = tableSizeFor(t);
            }
            else if (s > threshold)
                resize();
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                K key = e.getKey();
                V value = e.getValue();
                putVal(hash(key), key, value, false, evict);
            }
        }
    }

    // 返回当前键值对个数
    public int size() {
        return size;
    }

    // 判断哈希表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 根据键获取值，不存在返回null
    public V get(Object key) {
        Node<K,V> e;
        // 先计算出key对应的hash值，然后根据hash值和key去查询对应的值
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    // 查询指定hash、key对应的Node节点
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        // (n - 1) & hash 定位到对应的桶
        // tab[(n - 1) & hash]即链表首节点或红黑树根节点
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
            	// 如果是树节点，则执行TreeNode.getTreeNode()方法
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                // 遍历链表进行查询
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    // 判断某个键是否存在
    public boolean containsKey(Object key) {
        return getNode(hash(key), key) != null;
    }

    // 插入键值对
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        // 空表先进行扩容
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        // 空桶直接插入
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            	// 尾插法插入新节点
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // key存在
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            // key存在，执行更新操作
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        // 如果当前容量超过扩容阈值，则执行resize()操作
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

    // 扩容操作
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
        	// 超过最大值就不再扩充了，就只好随你碰撞去吧
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            // 扩容为之前的2倍
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        // 计算新的扩容阈值
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        // 原索引放到bucket里
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        // 原索引+oldCap放到bucket里
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    // 链表树化操作
    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        // hash表容量小于MIN_TREEIFY_CAPACITY时，进行扩容操作
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
        else if ((e = tab[index = (n - 1) & hash]) != null) {
            TreeNode<K,V> hd = null, tl = null;
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }

	// 将指定Map实例的所有键值对加入当前HashMap实例
    public void putAll(Map<? extends K, ? extends V> m) {
        putMapEntries(m, true);
    }

    // 删除指定键对应的键值对，并返回值，不存在返回null
    public V remove(Object key) {
        Node<K,V> e;
        return (e = removeNode(hash(key), key, null, false, true)) == null ?
            null : e.value;
    }
}

```

