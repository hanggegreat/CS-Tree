package cn.lollipop.mode.birdge;


public class DesktopComputer extends Computer {

    public DesktopComputer(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}
