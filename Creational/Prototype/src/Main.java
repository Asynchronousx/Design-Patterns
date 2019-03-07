public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShapeCloner.loadCachedShape();
        Shape a = ShapeCloner.getShape("triangle");
        Shape b = ShapeCloner.getShape("trIangle");

        a.draw();
        b.draw();

    }
}
