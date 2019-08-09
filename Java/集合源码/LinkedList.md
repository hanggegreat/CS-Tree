``` java
package java.util;

import java.util.function.Consumer;

public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{
    transient int size = 0;

    // 首节点，并且满足：
    // (first == null && last == null) || (first.prev == null && first.item != null)
    transient Node<E> first;

    // 尾节点，并且满足：
    // (first == null && last == null) || (last.next == null && last.item != null)
    transient Node<E> last;

    public LinkedList() {
    }

	// 将集合类型的实例转化为LinkedList类型实例
    public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    // 插入元素到链表首部。
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }
    
    // 插入元素到链表尾部。
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    // 在某个节点前面插入。
    void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    // 删除链表首节点并返回节点值。
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
    }

    // 删除链表尾节点并返回节点值。
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }

    // 删除指定节点。
    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    // 返回首节点的节点值。
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    // 返回尾节点的节点值。
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    // 删除首节点并返回节点值。
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    // 删除尾节点并返回节点值。
    public E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    // 插入节点到首部。
    public void addFirst(E e) {
        linkFirst(e);
    }

    // 插入节点到尾部。
    public void addLast(E e) {
        linkLast(e);
    }

    // 判断某个值是否存在。
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    // 返回当前保存的元素的个数。
    public int size() {
        return size;
    }

    // 插入元素到尾部。
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    // 删除指定元素，不存在则返回false。
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    // 插入指定类型的集合的全部元素到链表尾部。
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    // 插入指定类型的集合的全部元素到链表指定位置后部。
    public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        modCount++;
        return true;
    }

    // 清空链表。
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }


    // 得到指定位置的元素。
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    // 更新指定位置元素值。
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    // 向指定位置插入元素。
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    // 删除指定位置元素并返回元素值。
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    // 判断位置是否合法。
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    // 判断位置是否合法。
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    // 返回指定位置的Node对象。Node是链表中实际保存的节点类型。
    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    // 返回指定元素第一次出现的节点位置，不存在返回-1。
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    // 返回指定元素最后一次出现的节点位置，不存在返回-1。
    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (x.item == null)
                    return index;
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                index--;
                if (o.equals(x.item))
                    return index;
            }
        }
        return -1;
    }

    // 返回首节点的节点值。
    public E peek() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
    }

	// 返回首节点的节点值。
    public E element() {
        return getFirst();
    }

    // 删除首节点并返回节点值。
    public E poll() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }
    
    // 删除首节点并返回节点值。
    public E remove() {
        return removeFirst();
    }

    // 插入节点到链表首部。
    public boolean offer(E e) {
        return add(e);
    }

    // 插入节点到链表首部。
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    // 插入节点到链表尾部。
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

	// 返回首节点的节点值。
    public E peekFirst() {
        final Node<E> f = first;
        return (f == null) ? null : f.item;
     }

	// 返回尾节点的节点值。
    public E peekLast() {
        final Node<E> l = last;
        return (l == null) ? null : l.item;
    }

    // 删除首节点并返回节点值。
    public E pollFirst() {
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
    }

    // 删除尾节点并返回节点值。
    public E pollLast() {
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }

    // 插入节点到链表首部。
    public void push(E e) {
        addFirst(e);
    }

    // 删除首节点并返回节点值。
    public E pop() {
        return removeFirst();
    }

    // 删除指定元素第一次出现的节点。
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

	// 删除指定元素最后一次出现的节点。
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = last; x != null; x = x.prev) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
    
    // 用来保存元素值的类型，保存了前后节点指针和当前元素值，连接起来构成一个双向链表。
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

```

