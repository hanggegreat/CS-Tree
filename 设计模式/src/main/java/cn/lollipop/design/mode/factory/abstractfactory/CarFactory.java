package cn.lollipop.design.mode.factory.abstractfactory;

public interface CarFactory {

    Engine createEngine();

    Seat createSeat();
}
