package cn.lollipop.mode.facade;

public class SubSystem {

    public void turnOnTV() {
        System.out.println("打开电视");
    }

    public void setCD(String cd) {
        System.out.println("插入光盘：" + cd);
    }

    public void startWatching() {
        System.out.println("开始观看");
    }
}
