package cn.lollipop.design.mode.singleton;

/**
 * 懒汉式 - 线程安全
 * 在对getInstance()方法加上同步锁之后，就避免了同一时间多个线程共同执行实例化操作的问题
 * 但是加了同步锁之后势必会带来线程阻塞的问题，因此不推荐使用
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    public synchronized static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
