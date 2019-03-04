package cn.lollipop.design.mode.decorator;

public class SwimCar extends SuperCar {

    public SwimCar(Car car) {
        super(car);
    }

    public void swim() {
        System.out.println("在水中游");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}
