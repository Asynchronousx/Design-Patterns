public class Main {
    public static void main(String[] args) {
        //Creating a CONTEXT object.
        //Current state: NotDelivered (First state).
        Package myNewLaptop = new Package();

        //Checking the current state action
        myNewLaptop.showCondition();
        myNewLaptop.downgradeCondition();

        //Going next into the state (Delivering)
        myNewLaptop.updateCondition();

        //Checking
        myNewLaptop.showCondition();

        //Going next into the state (Delivered)
        myNewLaptop.updateCondition();

        //Checking
        myNewLaptop.showCondition();
        myNewLaptop.updateCondition();

    }
}
