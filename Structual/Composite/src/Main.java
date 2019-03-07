public class Main {
    public static void main(String[] args) {
        //Declaring a composite shape containing a list of triangle objects
        CompositeShape triangleShape = new CompositeShape();
        ShapeComponent triangle1 = new LeafTriangle();
        ShapeComponent triangle2 = new LeafTriangle();
        ShapeComponent triangle3 = new LeafTriangle();

        //Defining a composite shape containing a list of rectangle object
        CompositeShape rectangleShape = new CompositeShape();
        ShapeComponent rectangle1 = new LeafRectangle();
        ShapeComponent rectangle2 = new LeafRectangle();

        //Adding the shapes
        triangleShape
                .addShape(triangle1)
                .addShape(triangle2)
                .addShape(triangle3);

        //Calling the method
        triangleShape.draw();

        //Same
        rectangleShape
                .addShape(rectangle1)
                .addShape(rectangle2);
        rectangleShape.draw();
    }
}
