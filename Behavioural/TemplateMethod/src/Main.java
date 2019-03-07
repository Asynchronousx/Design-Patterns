public class Main {
    public static void main(String[] args) {
        Template computerBuilder = new EntryLevelComputer();
        System.out.println("\nInfo about new created PC:");
        computerBuilder.buildComputer()
                .getComputerParts()
                .forEach((k,v) -> System.out.println("Part: " + k + " - Value: " + v));


        computerBuilder = new HighLevelComputer();
        System.out.println("\nInfo about new created PC:");
        computerBuilder.buildComputer()
                .getComputerParts()
                .forEach((k,v) -> System.out.println("Part: " + k + " - Value: " + v));

    }
}
