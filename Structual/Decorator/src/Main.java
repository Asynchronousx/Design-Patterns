public class Main {
    public static void main(String[] args) {
        Car basicCar = new BasicCar();
        System.out.println(basicCar.assemble());

        Car luxuryEngineCar = new LuxuryEngine(new BasicCar());
        System.out.println(luxuryEngineCar.assemble());

        Car fullOptionalCar = new LuxuryEngine(new SportWheel(new AlluminiumFrame(new BasicCar())));
        System.out.println(fullOptionalCar.assemble());
    }
}
