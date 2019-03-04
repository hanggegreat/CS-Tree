package cn.lollipop.mode.decorator;

public class FlyCar extends SuperCar {

    public FlyCar(Car car) {
        super(car);
    }

    public void fly() {
        System.out.println("在天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}
