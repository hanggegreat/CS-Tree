package cn.lollipop.design.mode.templatemethod;

public class Tea extends CaffeineBeverage {

    @Override
    public void brew() {
        System.out.println("Tea.brew");
    }

    @Override
    public void addCondiments() {
        System.out.println("Tea.addCondiments");
    }
}