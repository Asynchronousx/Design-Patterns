public class Main {
    public static void main(String[] args) {
        EuropeanCar mustang = new EuropeanMustang(new AmericanMustang());
        System.out.println(mustang.getSpeed()+ " KMH");
        System.out.println(((EuropeanMustang) mustang).car.getSpeed() + "MPH");
    }
}
