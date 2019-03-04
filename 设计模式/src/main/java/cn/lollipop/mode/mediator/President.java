package cn.lollipop.mode.mediator;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator {

    private Map<String, Department> map = new HashMap<>();

    @Override
    public void command(String dest) {
        map.get(dest).selfAction();
    }

    @Override
    public void register(String name, Department d) {
        map.put(name, d);
    }
}
