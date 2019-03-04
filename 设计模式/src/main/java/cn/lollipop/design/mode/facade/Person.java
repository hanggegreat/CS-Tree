package cn.lollipop.design.mode.facade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person {

    private SubSystem subSystem;

    public void watchMovie(String cd) {
        subSystem.turnOnTV();
        subSystem.setCD(cd);
        subSystem.startWatching();
    }
}
