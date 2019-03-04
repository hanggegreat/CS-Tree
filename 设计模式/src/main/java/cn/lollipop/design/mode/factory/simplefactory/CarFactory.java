package cn.lollipop.design.mode.factory.simplefactory;

/**
 * 简单工厂
 */
public class CarFactory {

    private CarFactory(){
    }

    public static Car createAudi() {
        return new Audi();
    }

    public static Car createByd() {
        return new Byd();
    }
}
