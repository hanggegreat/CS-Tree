package cn.lollipop.design.mode.factory.abstractfactory;

public class LuxurySeat implements Seat {

    @Override
    public void seat() {
        System.out.println("坐得舒服");
    }
}
