public class Main {

    public static void main(String[] args) {
        //Defining the factory
        FlyweightFactory f = new FlyweightFactory();

        //Defining some color
        Color red = new Color("Red");
        Color blue = new Color("Blue");
        Color green = new Color("Green");

        //Creating the cars with the factory
        FlyweightCar car1 = f.getCar(red);
        FlyweightCar car2 = f.getCar(blue);
        FlyweightCar car3 = f.getCar(green);
        FlyweightCar car4 = f.getCar(red);
        FlyweightCar car5 = f.getCar(blue);

        //Printing info. -> Same ID on car means that the Car was taken from a cache.
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        System.out.println(car3.toString());
        System.out.println(car4.toString());
        System.out.println(car5.toString());

    }

}
