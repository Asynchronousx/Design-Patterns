public class Main {
    public static void main(String[] args) {
        Shape redTriangle = new Triangle(new Red("Red"));
        Shape bordeauxTriangle = new Triangle(new Red("Bordeaux"));
        Shape blueTriangle = new Triangle(new Blue("Blue"));
        Shape blueRectangle = new Rectangle(new Blue("Sky Blue"));
        Shape greenRectangle = new Rectangle(new Green("Green"));

        //Printing the draw
        redTriangle.draw();
        bordeauxTriangle.draw();
        blueTriangle.draw();
        blueRectangle.draw();
        greenRectangle.draw();

    }
}
