package cn.lollipop.mode.builder;

/**
 * 构造者模式
 */
public class Client {

    public static void main(String[] args) {
        AirShipDirector director = new LollipopAirShipDirector(new LollipopAirShipBuilder());
        AirShip ship = director.directAirShip();
        System.out.println(ship.getEngine().getName());
        System.out.println(ship.getEscapeTower().getName());
        System.out.println(ship.getOrbitalModule().getName());
    }
}
