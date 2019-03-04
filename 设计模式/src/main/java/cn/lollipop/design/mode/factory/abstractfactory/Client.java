package cn.lollipop.design.mode.factory.abstractfactory;

public class Client {

    public static void main(String[] args) {
        CarFactory luxuryCarFactory = new LuxuryCarFactory();
        Engine luxuryEngine = luxuryCarFactory.createEngine();
        Seat luxurySeat = luxuryCarFactory.createSeat();

        CarFactory lowCarFactory = new LowCarFactory();
        Engine lowEngine = lowCarFactory.createEngine();
        Seat lowSeat = lowCarFactory.createSeat();

        luxuryEngine.start();
        luxuryEngine.run();
        luxurySeat.seat();
        System.out.println("================");
        lowEngine.start();
        lowEngine.run();
        lowSeat.seat();
    }
}
