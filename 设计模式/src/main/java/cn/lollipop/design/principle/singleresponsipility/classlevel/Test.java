package cn.lollipop.design.principle.singleresponsipility.classlevel;

public class Test {
    public static void main(String[] args) {
        FlyBird flyBird = new FlyBird("老鹰");
        WalkBird walkBird = new WalkBird("鸵鸟");
        flyBird.moveMode();
        walkBird.moveMode();
    }
}
