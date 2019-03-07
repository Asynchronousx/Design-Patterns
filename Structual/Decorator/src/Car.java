//Interface to define a basic object to decorate: in this case, a car.
public interface Car {
    String assemble();
}

//The concrete implementation of the basic object
class BasicCar implements Car {

    @Override
    public String assemble() {
        return "You got a: Basic car";
    }

}

//Optional wrapper: it wrap a basic object and will perform the decoration operation.
abstract class CarDecorator implements Car {
    Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public String assemble() {
        return car.assemble();
    }
}

//Optional decoration 1: putting the luxury engine into the car
class LuxuryEngine extends CarDecorator {

    public LuxuryEngine(Car car) {
        super(car);
    }

    @Override
    public String assemble() {
        return super.assemble() + assembleWithLuxuryEngine();
    }

    public String assembleWithLuxuryEngine() {
        return " with luxury engine";
    }
}

//Optional decoration 1a: putting a sport engine into the car
class SportEngine extends CarDecorator {

    public SportEngine(Car car) {
        super(car);
    }

    @Override
    public String assemble() {
        return super.assemble() + assembleWithSportEngine();
    }

    public String assembleWithSportEngine() {
        return " with sport engine";
    }
}

//Optional decoration 2: putting the alluminium frame on the car
class AlluminiumFrame extends CarDecorator {

    public AlluminiumFrame(Car car) {
        super(car);
    }

    @Override
    public String assemble() {
        return super.assemble() + assembleWithAlluminiumFrame();
    }

    public String assembleWithAlluminiumFrame() {
        return " with alluminium frame";
    }
}

//optional decoration 3: putting the sports wheel to the car.
class SportWheel extends CarDecorator {

    public SportWheel(Car car) {
        super(car);
    }

    @Override
    public String assemble() {
        return super.assemble() + assembleWithSportWheel();
    }

    public String assembleWithSportWheel() {
        return " with sport wheel";
    }
}


