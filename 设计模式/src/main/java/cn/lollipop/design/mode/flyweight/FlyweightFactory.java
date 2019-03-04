package cn.lollipop.design.mode.flyweight;

import java.util.HashMap;

public class FlyweightFactory {

    private static HashMap<String, Flyweight> map = new HashMap<>();

    public static Flyweight getFlyweight(String intrinsicState) {
        if (!map.containsKey(intrinsicState)) {
            map.put(intrinsicState, new ConcreteFlyweight(intrinsicState));
        }

        return map.get(intrinsicState);
    }
}
