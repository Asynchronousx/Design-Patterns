public class Main {
    public static void main(String[] args) {
        //Defining cars: constructor take "IS BROKEN / OWNER" in input.
        Car audi = new Car(true, "Giovanni");
        Car volvo = new Car(true,"Paolo");
        Car opel = new Car(true, "Sebastian");

        //Defining a mechanics: adding the cars to the queue
        Mechanic mechanic = new Mechanic();
        mechanic.addCar(audi);
        mechanic.addCar(volvo);
        mechanic.addCar(opel);

        //Defining actions
        Command repair = new RepairCommand(mechanic);
        Command info = new InfoCommand(mechanic);

        //Invoking
        Reception reception = new Reception();
        reception.performOperation("Repair", repair);
        reception.performOperation("Info", info);
        reception.performOperation("Repair", repair);
        reception.performOperation("Info", info);
        reception.performOperation("Repair", repair);
        reception.performOperation("Info", info);

    }
}
