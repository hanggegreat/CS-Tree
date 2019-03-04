package cn.lollipop.design.mode.singleton;

/**
 * 静态内部类实现 - 线程安全
 * 当Singleton类加载时，静态内部类SingletonHolder没有被加载进内存
 * 只有当调用了getInstance()方法从而触发SingletonHolder.INSTANCE时SingletonHolder类才会被加载，此时初始化INSTANCE所指向单例对象
 * 虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，
 * 如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕。
 * JVM在这个过程中保证了单例对象只会初始化一次
 */
public class Singleton4 {
    private Singleton4() {
    }

    private static class SingletonHolder {
        private final static Singleton4 INSTANCE = new Singleton4();
    }

    public Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
