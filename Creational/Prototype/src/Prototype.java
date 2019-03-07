import java.util.HashMap;
import java.util.Map;


//Prototype Class: the one who'll clone the object stored into a data structure (in this case, a map)
class ShapeCloner {
    protected static Map<String, Shape> shapeMap = new HashMap<>();

    //get shape is the getclone function
    public static Shape getShape(String s) {

        s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();

        if(shapeMap == null || shapeMap.get(s) == null) {
            System.out.println("Shape map or string invalid. Try loadCachedShape().");
        }

        Shape shape = null;

        try {
            shape = (Shape)shapeMap.get(s).clone();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return shape;
    }

    //before reclaiming a shape, an user should load the cached prototype into the memory.
    public static void loadCachedShape() {
        Shape a = new Rectangle();
        Shape b = new Square();
        Shape c = new Triangle();

        a.type = "Rectangle";
        b.type = "Square";
        c.type = "Triangle";

        a.id = 1;
        b.id = 2;
        c.id = 3;

        shapeMap.put(a.type, a);
        shapeMap.put(b.type, b);
        shapeMap.put(c.type, c);
    }
}

//abstract product class shape
abstract class Shape implements Cloneable {
    protected int id;
    protected String type;

    public String getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract void draw();
}

//concretes products class
class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("I'm a " + getType() + ". My id is: " + getId() + ".");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("I'm a " + getType() + ". My id is: " + getId() + ".");
    }
}

class Triangle extends Shape {
    String s = "test";
    @Override
    public void draw() {
        System.out.println("I'm a " + getType() + ". My id is: " + getId() + ".");
    }
}