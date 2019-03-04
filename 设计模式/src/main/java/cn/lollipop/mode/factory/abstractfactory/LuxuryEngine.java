package cn.lollipop.mode.factory.abstractfactory;

public class LuxuryEngine implements Engine {

    @Override
    public void run() {
        System.out.println("跑得快");
    }

    @Override
    public void start() {
        System.out.println("自动启动");
    }
}
