package cn.lollipop.design.mode.iterator;

/**
 * 聚合接口
 */
public interface Aggregate<T> {

    Iterator<T> iterator();

    boolean add(T t);

    boolean remove(T t);
}
