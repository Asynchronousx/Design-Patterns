import java.util.HashMap;
import java.util.Map;


//The FlyWeight is our Object interface: In this example, a Car.
public interface FlyweightCar {
    void start();
    void stop();
    Color getColor();
    Engine getEngine();
}

//The Concrete Flyweight object: a car.
class Car implements FlyweightCar {
    private Engine engine;
    private Color color;
    private int localid;
    private static int staticid = 0;


    public Car(Engine e, Color c) {
        this.engine = e;
        this.color = c;
        this.localid = staticid++;
    }

    @Override
    public void start() {
        this.engine.startEngine();
    }

    @Override
    public void stop() {
        this.engine.stopEngine();
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public String toString() {
        return "Car -> Engine: " + engine.getEngineName() + " - Color: " + color.colorName + " - Model No. : "  + this.localid;
    }
}

//Flyweight factory
class FlyweightFactory {
    //HashMap for memorizing the already-created object -> caching car for their color.
    //The Intrinsic object is the car itself. (Because, making a car is kinda expensive).
    private Map<Color, FlyweightCar> cachedCars;

    public FlyweightFactory() {
        this.cachedCars = new HashMap<>();
    }

    //Methods to return a car: if the color passed is already
    //present as key into the cachedCars map, then return the associated value.
    //Otherwise, create a new Car and associate that with the passed color.
    //We'll use computeIfAbsent to get this done in few code lines.
    public FlyweightCar getCar(Color color) {
        FlyweightCar newCar = this.cachedCars.computeIfAbsent(color, newColorKey -> {
            Engine e = new Engine("Standard Engine");
            return new Car(e, newColorKey);
        });
        return newCar;
    }
}


//Engine and color class are our Extrinsic parts of the object.
//Engine class. For Example purpose.
class Engine {
    private String engineName;

    public Engine(String name) {
        this.engineName = name;
    }

    public String getEngineName() {
        return engineName;
    }

    public void startEngine() {
        System.out.println("Engine started");
    }

    public void stopEngine() {
        System.out.println("Engine stopped.");
    }
}

//Color class. For Example purpose.
class Color {
    String colorName;

    public Color(String colorName) {
        this.colorName = colorName;
    }

}