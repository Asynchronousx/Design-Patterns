import java.util.*;

//Command
public interface Command {
    void execute();
}

//Concrete Command
class RepairCommand implements Command {
    Mechanic mechanic;

    public RepairCommand(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    @Override
    public void execute() {
        mechanic.repairCar();
    }
}

//Concrete Command
class InfoCommand implements Command {
    Mechanic mechanic;

    public InfoCommand(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    @Override
    public void execute() {
        System.out.println(mechanic.giveInfoAboutRepair());
    }
}

//Receiver
class Mechanic {
    protected Queue<Car> carQueue = new LinkedList<>();

    public void repairCar() {
        if(carQueue.size() != 0) {
            Car car = carQueue.remove();
            if(!car.getIsBroken()) {
                System.out.println(car.owner + "'s car wasn't broken. Didn't repair.");
            } else {
                car.setIsBroken(false);
                System.out.println(car.owner + "'s car got repaired.");
            }
        }
    }

    public String giveInfoAboutRepair() {
        String[] repairInfo = {"Engine broken", "Engine needed oil", "Wheels broken", "Steering wheel broken"};
        Random r = new Random();
        return repairInfo[r.nextInt(repairInfo.length)];
    }

    public void addCar(Car car) {
        carQueue.add(car);
    }

}

//Object needed by receiver
class Car {
    private Boolean isBroken = false;
    public String owner;

    public Car(Boolean isBroken, String owner) {
        this.isBroken = isBroken;
        this.owner = owner;
    }

    public void setIsBroken(Boolean broken) {
        isBroken = broken;
    }

    public Boolean getIsBroken() {
        return isBroken;
    }
}

//Invoker
class Reception {
    Map<String, Command> commands = new HashMap<>();

    public void performOperation(String operation, Command toExecute) {
        commands.put(operation, toExecute);
        toExecute.execute();
    }

}