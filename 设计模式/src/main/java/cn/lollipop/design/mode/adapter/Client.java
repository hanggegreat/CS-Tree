package cn.lollipop.design.mode.adapter;

/**
 * 适配器模式
 * 客户端类
 */
public class Client {

    public void test(Target t) {
        t.handleRequest();
    }

    public static void main(String[] args) {
        Client client = new Client();
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        client.test(adapter);
    }
}
