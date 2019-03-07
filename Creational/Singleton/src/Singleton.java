public class Singleton {
    //Static instance of itself: thats because the Singleton must be
    //Accessed either without initialization or with.
    private static Singleton singleton;

    //Private constructor
    private Singleton() {}

    //Methods: access point to the singleton
    public static Singleton useInstance() {
        return singleton == null? new Singleton(): singleton;
    }

    public void printHello() {
        System.out.println("Hello Singleworld!");
    }
}
