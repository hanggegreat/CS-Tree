package cn.lollipop.design.mode.flyweight;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    @Override
    public void doOperation(String extrinsicState) {
        System.out.println("Object address = " + System.identityHashCode(this));
        System.out.println("IntrinsicState = " + intrinsicState);
        System.out.println("extrinsicState = " + extrinsicState);
    }
}
