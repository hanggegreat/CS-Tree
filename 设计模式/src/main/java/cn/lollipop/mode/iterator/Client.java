package cn.lollipop.mode.iterator;

/**
 * 迭代器模式
 */
public class Client {

    public static void main(String[] args) {
        Aggregate<Integer> aggregate = new ConcreteAggregate<>();
        for (int i = 0; i < 10; i++) {
            aggregate.add(i);
        }

        Iterator<Integer> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
