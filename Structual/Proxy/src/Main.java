public class Main {
    public static void main(String[] args) {
        //Creating a new proxy
        HeavyObject obj = new HeavyObjectProxy();
        //Creating time measuring object
        long startTime, endTime;

        //Heavy object init will be done only on the first call thanks to lazy init.
        startTime = System.nanoTime();
        obj.processHeavyData();
        endTime = System.nanoTime();
        System.out.println("Time passed: " + ((endTime-startTime)/100000));

        //Process data already created on internal static HeavyObjectImpl.
        startTime = System.nanoTime();
        obj.processHeavyData();
        endTime = System.nanoTime();
        System.out.println("Time passed: " + ((endTime-startTime)/100000));
    }
}
