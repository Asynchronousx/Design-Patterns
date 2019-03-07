import java.util.ArrayList;
import java.util.List;

//ShapeComponent is our Composite Root Class. It defines the behaviour of his children.
public interface ShapeComponent {
    void draw();
}

//Leaf class are the single object that will represent the entity representation of the root class.
//They perform the method draw.
class LeafTriangle implements ShapeComponent {
    @Override
    public void draw() {
        System.out.println("I'm a Triangle.");
    }
}

class LeafRectangle implements ShapeComponent {
    @Override
    public void draw() {
        System.out.println("I'm a rectangle.");
    }
}

//Composite shape is the Middle class of the Composite pattern. It is composed by a list of ShapeComponent,
//and the method draw will call draw on every leaf class of the list.
class CompositeShape implements ShapeComponent {
    private List<ShapeComponent> shapeList;

    public CompositeShape() {
        this.shapeList = new ArrayList<>();
    }

    //Setters/Getters
    public CompositeShape addShape(ShapeComponent shape) {
        this.shapeList.add(shape);
        return this;
    }

    public CompositeShape removeShape(ShapeComponent shape) {
        this.shapeList.remove(shape);
        return this;
    }

    @Override
    public void draw() {
        shapeList.forEach((s) -> s.draw());
    }
}

