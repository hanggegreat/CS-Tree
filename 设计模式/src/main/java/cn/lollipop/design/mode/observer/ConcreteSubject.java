package cn.lollipop.design.mode.observer;


public class ConcreteSubject extends Subject {

    private int state;

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    public int getState() {
        return state;
    }
}
