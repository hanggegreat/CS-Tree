package cn.lollipop.mode.factory.abstractfactory;

public class LowEngine implements Engine {

    @Override
    public void run() {
        System.out.println("跑得慢");
    }

    @Override
    public void start() {
        System.out.println("启动慢");
    }
}
