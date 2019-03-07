public class Main {
    public static void main(String[] args) {
        Facade builder = new BuildRobot();
        builder.assembleRobot()
                .forEach((k,v) -> System.out.println(k + ": " + v));

    }
}
