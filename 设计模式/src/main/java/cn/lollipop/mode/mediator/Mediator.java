package cn.lollipop.mode.mediator;

/**
 * 中介者接口
 */
public interface Mediator {

    void command(String dest);

    void register(String name, Department d);
}
