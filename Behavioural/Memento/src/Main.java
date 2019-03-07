import java.util.Stack;

public class Main {

    //Memento stack to restore states
    static Stack<Memento> mementoStack = new Stack<>();

    public static void main(String[] args) {
        //Creating an originator object and a memento object with current calculator state.
        Calculator calc = new Calculator();
        Memento memento = calc.createMemento();

        //Adding the last known state to the memento stack and performing the operation.
        mementoStack.push(memento);
        calc.add(10, 15);

        //Same as above
        memento = calc.createMemento();
        mementoStack.push(memento);
        calc.add(22,10);

        //Showing the current state of operation
        calc.printCurState();

        //rollback to 10 + 15;
        //Pop the last state from the memento stack and pass it to the undo function
        calc.undo(mementoStack.pop());

        //print the state of operation
        calc.printCurState();

        //another rollback
        calc.undo(mementoStack.pop());
        calc.printCurState();

    }
}
