package cn.lollipop.mode.templatemethod;

public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public abstract void brew();

    public abstract void addCondiments();

    public void boilWater() {
        System.out.println("boilWater");
    }

    public void pourInCup() {
        System.out.println("pourInCup");
    }
}