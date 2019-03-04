package cn.lollipop.design.mode.strategy;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("quack!");
    }
}