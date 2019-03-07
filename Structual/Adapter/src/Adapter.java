//Target
interface EuropeanCar {
    Double getSpeed();
}

//Adapter
class EuropeanMustang implements EuropeanCar {
    AmericanCar car;

    public EuropeanMustang(AmericanCar car) {
        this.car = car;
    }

    @Override
    public Double getSpeed() {
        return convertMPHtoKMH(car.getSpeed());
    }

    public Double convertMPHtoKMH(Double speed) {
        return speed * 1.60934;
    }

}

//Adaptee class
interface AmericanCar {
    Double getSpeed();
}

class AmericanMustang implements AmericanCar {
    public Double speed = 150.5;


    @Override
    public Double getSpeed() {
        return speed;
    }
}
