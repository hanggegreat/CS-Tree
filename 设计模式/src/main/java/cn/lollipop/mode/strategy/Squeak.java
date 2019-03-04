package cn.lollipop.mode.strategy;


public class Squeak implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}