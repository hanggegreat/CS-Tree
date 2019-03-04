package cn.lollipop.mode.builder;

import lombok.Data;

@Data
public class AirShip {
    private OrbitalModule orbitalModule; // 轨道舱
    private Engine engine; // 发动机
    private EscapeTower escapeTower; // 逃逸塔
}
