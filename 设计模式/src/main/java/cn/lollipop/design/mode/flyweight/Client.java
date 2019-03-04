package cn.lollipop.design.mode.flyweight;

/**
 * 享元模式
 * 利用共享的方式来支持大量细粒度的对象，这些对象一部分内部状态是相同的。
 */
public class Client {

    public static void main(String[] args) {
        Flyweight flyweight1 = FlyweightFactory.getFlyweight("奥特曼");
        flyweight1.doOperation("打怪兽");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("奥特曼");
        flyweight2.doOperation("打奥特曼");
    }
}
