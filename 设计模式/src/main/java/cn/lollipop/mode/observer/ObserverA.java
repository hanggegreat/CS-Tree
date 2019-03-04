package cn.lollipop.mode.observer;

import lombok.Data;

@Data
public class ObserverA implements Observer {
    private int state;

    @Override
    public void update(Subject subject) {
        state = ((ConcreteSubject)subject).getState();
    }
}
