package cn.lollipop.mode.state;

/**
 * 状态模式
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();

        context.setState(new FreeState());

        context.setState(new BookedState());

        context.setState(new CheckedInState());
    }
}
