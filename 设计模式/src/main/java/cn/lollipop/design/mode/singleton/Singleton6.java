package cn.lollipop.design.mode.singleton;

import java.io.Serializable;

/**
 * 饿汉式 - 线程安全
 * 线程不安全问题产生的主要原因是instance被多次实例化
 * 而采取直接实例化instance的方式就不会产生线程不安全问题
 * 但是直接实例化的方式也失去了延迟实例化带来的节约资源的好处
 */
public class Singleton6 implements Serializable {
    private static Singleton6 instance = new Singleton6();

    private Singleton6() {
        // 防止反射调用构造方法实例化
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    public static Singleton6 getInstance() {
        return instance;
    }

    // 防止反序列化实例化对象
    private Object readResove() {
        System.out.println("read resolve");
        return instance;
    }
}
