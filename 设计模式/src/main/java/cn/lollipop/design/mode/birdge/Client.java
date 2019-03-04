package cn.lollipop.design.mode.birdge;

/**
 * 桥接模式
 */
public class Client {

    public static void main(String[] args) {
        Computer lenovoLaptop = new LaptopComputer(new Lenovo());
        Computer shenzhouPad = new PadComputer(new Shenzhou());

        lenovoLaptop.sale();
        shenzhouPad.sale();
    }
}
