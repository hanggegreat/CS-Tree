package cn.lollipop.design.principle.singleresponsipility.classlevel;

public class FlyBird {
    private String name;

    public FlyBird(String name) {
        this.name = name;
    }

    public void moveMode() {
        System.out.println("在天上飞");
    }
}
