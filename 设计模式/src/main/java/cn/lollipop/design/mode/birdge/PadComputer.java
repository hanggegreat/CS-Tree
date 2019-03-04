package cn.lollipop.design.mode.birdge;

public class PadComputer extends Computer {

    public PadComputer(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售平板电脑");
    }
}
