package cn.lollipop.mode.observer;

/**
 * 观察者模式
 */
public class Client {

    public static void main(String[] args) {
        ObserverA observer1 = new ObserverA();
        ObserverA observer2 = new ObserverA();
        ObserverA observer3 = new ObserverA();
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);

        subject.setState(3000);

        System.out.println(observer1.getState());
        System.out.println(observer2.getState());
        System.out.println(observer3.getState());
    }
}
