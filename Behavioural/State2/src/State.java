import java.util.Stack;

public interface State {
    void doAction();
    void next(Package ctx);
    void prev(Package ctx);
}

//Context: Package
class Package {
    private State nextState;

    public Package() {
        this.nextState = new NotDelivered();
    }

    //Setters/Getters
    public State getState() { return nextState; }
    public void setState(State nextState) { this.nextState = nextState; }

    //Methods
    public void updateCondition() {
        nextState.next(this);
    }

    public void downgradeCondition() {
        nextState.prev(this);
    }

    public void showCondition() {
        nextState.doAction();
    }

}

class NotDelivered implements State {
    @Override
    public void doAction() {
        System.out.println("Package not delivered yet.");
    }

    @Override
    public void next(Package ctx) {
        ctx.setState(new Delivering());
    }

    @Override
    public void prev(Package ctx) {
        System.out.println("Currently cannot downgrade state.");
    }
}

class Delivering implements State {
    @Override
    public void doAction() {
        System.out.println("Package is in delivery.");
    }

    @Override
    public void next(Package ctx) {
        ctx.setState(new Delivered());
    }

    @Override
    public void prev(Package ctx) {
        ctx.setState(new NotDelivered());
    }
}

class Delivered implements State {
    @Override
    public void doAction() {
        System.out.println("Package delivered.");
    }

    @Override
    public void next(Package ctx) {
        System.out.println("Package is delivered, cannot forward state.");
    }

    @Override
    public void prev(Package ctx) {
        ctx.setState(new Delivering());
    }
}
