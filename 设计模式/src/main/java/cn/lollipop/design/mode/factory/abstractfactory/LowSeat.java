package cn.lollipop.design.mode.factory.abstractfactory;

public class LowSeat implements Seat {

    @Override
    public void seat() {
        System.out.println("坐的难受");
    }
}
