public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        for(KindOfShape kind: KindOfShape.values()) {
            factory.getShape(kind).draw();
        }
    }

}

