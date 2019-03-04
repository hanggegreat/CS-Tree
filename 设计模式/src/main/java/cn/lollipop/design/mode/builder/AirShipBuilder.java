package cn.lollipop.design.mode.builder;

public interface AirShipBuilder {
    Engine buildEngine();
    OrbitalModule buildOrbitalModule();
    EscapeTower builderEscapeTower();
}
