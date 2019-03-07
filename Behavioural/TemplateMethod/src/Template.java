import java.util.HashMap;
import java.util.Map;

public abstract class Template {
    protected Map<String, Integer> computerParts = new HashMap<>();

    public final Computer buildComputer() {
        addMotherBoard();
        addCPU();
        addRAM();
        addGPU();
        addPSU();
        return new Computer(computerParts);
    }

    public abstract void addMotherBoard();
    public abstract void addCPU();
    public abstract void addRAM();
    public abstract void addGPU();
    public abstract void addPSU();

}

class Computer {
    private Map<String, Integer> computerParts;

    public Computer(Map<String, Integer> computerParts) {
        this.computerParts = computerParts;
    }

    public Map<String, Integer> getComputerParts() {
        return computerParts;
    }

    public void setComputerParts(Map<String, Integer> computerParts) {
        this.computerParts = computerParts;
    }
}

class EntryLevelComputer extends Template {

    @Override
    public void addMotherBoard() {
        System.out.println("Adding motherboard to computer.");
        computerParts.put("Asus X350", 150);
    }

    @Override
    public void addCPU() {
        System.out.println("Adding CPU to computer.");
        computerParts.put("Intel i5 7200", 169);
    }

    @Override
    public void addRAM() {
        System.out.println("Adding RAM to computer.");
        computerParts.put("8GB HyperX Fury DDR4 2400MHZ", 95);

    }

    @Override
    public void addGPU() {
        System.out.println("Adding GPU to computer.");
        computerParts.put("GTX 1050ti", 150);
    }

    @Override
    public void addPSU() {
        System.out.println("Adding PSU to computer.");
        computerParts.put("Corsair CX500", 50);
    }
}

class HighLevelComputer extends Template {

    @Override
    public void addMotherBoard() {
        System.out.println("Adding High-End motherboard to computer.");
        computerParts.put("Asus Rampage VI", 650);
    }

    @Override
    public void addCPU() {
        System.out.println("Adding High-End CPU to computer.");
        computerParts.put("Intel i9 9900X", 890);
    }

    @Override
    public void addRAM() {
        System.out.println("Adding High-End RAM to computer.");
        computerParts.put("Corsair 64GB Dominator Platinum 3600MHZ", 450);
    }

    @Override
    public void addGPU() {
        System.out.println("Adding High-End GPU to computer.");
        computerParts.put("GTX 2080ti", 1400);
    }

    @Override
    public void addPSU() {
        System.out.println("Adding High-End PSU to computer.");
        computerParts.put("Corsair AX1500i", 330);
    }
}