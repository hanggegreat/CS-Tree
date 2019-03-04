package cn.lollipop.mode.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class Client {
    public static void main(String[] args) {
        Star target = new RealStar();
        StarHandler handler = new StarHandler(target);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        proxy.sing();
    }
}
