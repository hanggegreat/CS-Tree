package cn.lollipop.design.principle.singleresponsipility.classlevel;

public class WalkBird {
    private String name;

    public WalkBird(String name) {
        this.name = name;
    }

    public void moveMode() {
        System.out.println("在地上走");
    }
}
