package cn.lollipop.mode.templatemethod;

public class Coffee extends CaffeineBeverage {

    @Override
    public void brew() {
        System.out.println("Coffee.brew");
    }

    @Override
    public void addCondiments() {
        System.out.println("Coffee.addCondiments");
    }
}