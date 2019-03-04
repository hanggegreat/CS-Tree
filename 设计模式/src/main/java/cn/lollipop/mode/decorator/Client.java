package cn.lollipop.mode.decorator;

/**
 * 装饰器模式
 */
public class Client {

    public static void main(String[] args) {
        Car car = new CommonCar();
        car.move();
        System.out.println("===============");

        Car car1 = new SwimCar(car);
        car1.move();
        System.out.println("===============");

        Car car2 = new FlyCar(car1);
        car2.move();
    }
}
