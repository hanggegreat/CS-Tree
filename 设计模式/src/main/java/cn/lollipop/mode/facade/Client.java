package cn.lollipop.mode.facade;

/**
 * 观察者模式
 */
public class Client {

    public static void main(String[] args) {
        Person person = new Person(new SubSystem());
        person.watchMovie("奥特曼打怪兽");
    }
}
