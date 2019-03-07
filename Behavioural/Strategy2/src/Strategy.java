import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public interface Strategy {
    void move();
}


class Field {
    private Robot robot;
    private List<Integer> field;
    private Integer columnRowSize;

    public Field() {
        this.field = new ArrayList<>(25);
        this.robot = new Robot();
        this.columnRowSize = 5;
        for(int i=0; i<25; i++) {
            this.field.add(0);
        }
        this.field.set(25/2, 1);

    }

    public void showField() {
        int counter = 0;
        for(int i=0; i<this.field.size(); i++) {
            if(counter != 4) {
                System.out.print(this.field.get(i) + " ");
                counter++;
            } else {
                System.out.println(this.field.get(i));
                counter = 0;
            }
        }
    }

}

class Robot {
    Strategy moving;

    public void setMoving(Strategy moving) {
        this.moving = moving;
    }

    public void moveSomewhere() {
        moving.move();
    }
}

class MoveLeft implements Strategy {
    @Override
    public void move() {
        System.out.println("I'm moving left.");
    }
}

class MoveRight implements Strategy {
    @Override
    public void move() {
        System.out.println("I'm moving right.");
    }
}

class MoveUp implements Strategy {
    @Override
    public void move() {
        System.out.println("I'm moving up.");
    }
}

class MoveDown implements Strategy {
    @Override
    public void move() {
        System.out.println("I'm moving down.");
    }
}
