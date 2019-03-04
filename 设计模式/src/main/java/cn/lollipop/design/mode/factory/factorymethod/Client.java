package cn.lollipop.design.mode.factory.factorymethod;

public class Client {

    public static void main(String[] args) {
        Car audi = AudiFactory.createCar();
        Car byd = BydFactory.createCar();

        audi.run();
        byd.run();
    }
}
