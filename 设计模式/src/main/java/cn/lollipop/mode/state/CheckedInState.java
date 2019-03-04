package cn.lollipop.mode.state;

/**
 * 已入住状态
 */
public class CheckedInState implements State {

    @Override
    public void handle() {
        System.out.println("房间已入住！请勿打扰！");
    }
}
