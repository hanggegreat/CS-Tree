package cn.lollipop.design.mode.mediator;

/**
 * 中介者模式
 */
public class Client {

    public static void main(String[] args) {
        Mediator mediator = new President();
        Department development = new Development(mediator);
        Department financial = new Financial(mediator);
        development.selfAction();
        development.outAction("financial");
    }
}
