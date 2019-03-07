//Abstraction
public interface Shape {
    void draw();
}

//ConcreteAbstraction
class Triangle implements Shape {
    Color color;

    public Triangle(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("I'm a " + color.getColor() + " triangle.");
    }
}

class Rectangle implements Shape {
    Color color;

    public Rectangle(Color color) {
        this.color = color;
    }


    @Override
    public void draw() {
        System.out.println("I'm a " + color.getColor() + " rectangle.");
    }
}


//Implementor
interface Color {
    String getColor();
}

//Concrete implementation
class Red implements Color {
    private String color;

    public Red(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}

class Blue implements Color {
    private String color;

    public Blue(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}

class Green implements Color {
    private String color;

    public Green(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}

