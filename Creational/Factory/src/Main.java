public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Factory.Animal object;
        for(AnimalsType type: AnimalsType.values()) {
            object = factory.getObjectNamed(type);
            System.out.println(object.getVerse());
        }
    }
}
