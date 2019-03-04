package cn.lollipop.mode.factory.simplefactory;

public class Client {

    public static void main(String[] args) {
        Car audi = CarFactory.createAudi();
        Car byd = CarFactory.createByd();

        audi.run();
        byd.run();
    }
}
