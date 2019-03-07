public interface Strategy {
    void move();
}

//Context class: Note how, the robot can move left, right, down and up
//But the actions are divided into 4 modules defined by the strategy interface.
//That make our robot class adherent to LSP and OCP, making the logic less complex
//And thanks to that, we can add kind of moving/modifying the existent one without
//Touching the Robot class.
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
