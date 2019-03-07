public class Main {
    public static void main(String[] args) {
        //Context class
        Robot robot = new Robot();

        //Concrete strategies
        Strategy moveDown = new MoveDown();
        Strategy moveUp = new MoveUp();
        Strategy moveLeft = new MoveLeft();
        Strategy moveRight = new MoveRight();

        //adding strategies to the context class and making execute them
        robot.setMoving(moveDown);
        robot.moveSomewhere();
        robot.moveSomewhere();
        robot.setMoving(moveLeft);
        robot.moveSomewhere();
        robot.moveSomewhere();
        robot.setMoving(moveRight);
        robot.moveSomewhere();
        robot.setMoving(moveUp);
        robot.moveSomewhere();

    }
}
