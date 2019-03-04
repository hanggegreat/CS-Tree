package cn.lollipop.mode.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 聚合类
 */
public class ConcreteAggregate<T> implements Aggregate<T> {

    private List<T> list = new ArrayList<>();

    @Override
    public boolean add(T t) {
        return list.add(t);
    }

    @Override
    public boolean remove(T t) {
        return list.remove(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements Iterator<T> {
        private int position = 0;

        @Override
        public T next() {
            return list.get(position++);
        }

        @Override
        public boolean hasNext() {
            return position < list.size();
        }
    }

}
