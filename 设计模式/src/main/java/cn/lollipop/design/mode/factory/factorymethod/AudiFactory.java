package cn.lollipop.design.mode.factory.factorymethod;

public class AudiFactory {

    private AudiFactory(){
    }

    public static Car createCar() {
        return new Audi();
    }
}
