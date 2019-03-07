public interface Memento {
    void restoreState();
}

//Originator class
class Calculator {
    //Current state of the calculator
    private int currentState = 0;

    private int getOriginatorCurrentState() {
        return currentState;
    }

    private void setOriginatorCurrentState(int currentState) {
        this.currentState += currentState;
    }


    //Undo operation to return to the last state
    public void undo(Memento memento) {
        System.out.println("Undoing..");
        memento.restoreState();
    }

    public Memento createMemento() {
        return new CalculatorMemento(getOriginatorCurrentState());
    }


    //Concrete Memento class
    private class CalculatorMemento implements Memento {
        private int state;

        public CalculatorMemento(int state) {
            this.state = state;
        }

        @Override
        public void restoreState() {
            currentState = state;
        }
    }

    public void add(int n1, int n2) {
        int sum = n1+n2;
        System.out.println("Sum of " + n1 + "+" + n2 + ": " + sum);
        setOriginatorCurrentState(sum);
    }

    public void printCurState() {
        System.out.println("Current state is: " + getOriginatorCurrentState());
    }

}
