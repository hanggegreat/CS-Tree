package cn.lollipop.design.mode.builder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class LollipopAirShipDirector implements AirShipDirector {

    private AirShipBuilder builder;

    @Override
    public AirShip directAirShip() {
        AirShipBuilder builder = new LollipopAirShipBuilder();
        AirShip ship = new AirShip();
        ship.setEngine(builder.buildEngine());
        ship.setEscapeTower(builder.builderEscapeTower());
        ship.setOrbitalModule(builder.buildOrbitalModule());
        return ship;
    }
}
