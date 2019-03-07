public interface AbstractFactory {
    Shape getShape(KindOfShape kind);
}

class ConcreteFactory implements AbstractFactory {
    @Override
    public Shape getShape(KindOfShape kind) {

        switch(kind) {
            case Square:
                return new Square();

            case Triangle:
                return new Triangle();

            case Rectangle:
                return new Rectangle();

            default:
                return null;
        }

    }
}

enum KindOfShape {
    Square,
    Triangle,
    Rectangle
}

interface Shape {
    void draw();
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm a triangle.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm a square");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm a rectangle.");
    }
}


