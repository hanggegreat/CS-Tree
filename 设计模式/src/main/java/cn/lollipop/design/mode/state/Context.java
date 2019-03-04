package cn.lollipop.design.mode.state;

public class Context {

    private State state;

    public void setState(State state) {
        System.out.println("修改状态");
        this.state = state;
        state.handle();
    }
}
