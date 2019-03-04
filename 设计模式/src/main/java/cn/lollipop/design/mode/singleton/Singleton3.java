package cn.lollipop.design.mode.singleton;

/**
 * 饿汉式 - 线程安全（双重校验锁）
 * 单例对象只需要被实例化一次，之后就可以直接使用了。加锁操作只有在实例化对象的那段代码中进行，即只有当单例对象尚未实例化的时候执行
 * <p>
 * 如果去掉同步代码块中的if语句，在 uniqueInstance == null 的情况下，如果两个线程都执行了 if 语句，那么两个线程都会进入 if 语句块内。
 * 虽然在if语句块内有加锁操作，但是两个线程都会执行 uniqueInstance = new Singleton(); 这条语句，那么就会进行两次实例化。
 * 因此必须使用双重校验锁，也就是需要使用两个 if 语句。
 * <p>
 * instance 采用 volatile 关键字修饰也是很有必要的， instance = new Singleton(); 这段代码其实是分为三步执行：
 * <p>
 * 为单例对象分配内存空间
 * 初始化单例对象
 * 将instance指向分配的内存地址
 * 但是由于JVM具有指令重排的特性，执行顺序有可能变成 1 > 3 > 2。
 * 指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。
 * 例如，线程T1执行了1和3，此时T2调用getInstance()后发现instance不为空，因此返回 instance，但此时 uniqueInstance 还未被初始化。
 * <p>
 * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
 */
public class Singleton3 {
    private static volatile Singleton3 instance;

    private Singleton3() {
    }

    private Singleton3 getInstance() {
        if (instance != null) {
            synchronized (Singleton3.class) {
                if (instance != null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
