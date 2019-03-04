package cn.lollipop.design.mode.singleton;

/**
 * 饿汉式 - 线程安全
 * 线程不安全问题产生的主要原因是instance被多次实例化
 * 而采取直接实例化instance的方式就不会产生线程不安全问题
 * 但是直接实例化的方式也失去了延迟实例化带来的节约资源的好处
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
