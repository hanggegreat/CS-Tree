package cn.lollipop.design.mode.birdge;

public class LaptopComputer extends Computer {

    public LaptopComputer(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本电脑");
    }
}
