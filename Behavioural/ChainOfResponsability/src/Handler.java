//Handler class of the Chain of Responsability DP.
//In here, we'll name a successor that will handle the request if the predecessor is not able
//or capable of resolving it by himself. We store the reference into the successor of Handler class type.
//Successors are handler class subtypes.
public abstract class Handler {
    private Handler successor;
    private final int MULTIPLIER = 100;

    public Handler getSuccessor() {
        return successor;
    }

    public int getMULTIPLIER() {
        return MULTIPLIER;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }


    //Handling the request scrolling through the chain of responsability: if the request (represented by a class)
    //can be satisfied, a message of success will be printed.
    //Otherwise, if no sucessors are available, it means that the request cannot be satisfied: otherwise,
    //go up into the chain of responsability to check out who's the next successor who can handle the request.
    public void handleRequest(Request request) {
        if(request.getAmount() < this.getAllowable()) {
            System.out.println("Request of " + request.getAmount() + " satisfied by: " + this.returnInfo());
        } else {
            if(getSuccessor() == null) {
                System.out.println("Request cannot be satisfied by no one. -> Max allowable: " + this.getAllowable());
            } else {
                getSuccessor().handleRequest(request);
            }
        }
    }

    public abstract double getAllowable();
    public abstract String returnInfo();


}

//Request is the class that represent the requisite to satisfy in order to complete the action.
//The request will be delegated to the right handler.
class Request {
    private double amount;

    public Request(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

//Concrete handlers
class Vendor extends Handler {
    private final double allowable = getMULTIPLIER()*10;

    @Override
    public double getAllowable() {
        return this.allowable;
    }

    @Override
    public String returnInfo() {
        return "Vendor";
    }
}

class SalesManager extends Handler {
    private final double allowable = getMULTIPLIER()*20;

    @Override
    public double getAllowable() {
        return this.allowable;
    }

    @Override
    public String returnInfo() {
        return "Sales Manager";
    }
}

class AccountManager extends Handler {
    private final double allowable = getMULTIPLIER()*40;

    @Override
    public double getAllowable() {
        return this.allowable;
    }

    @Override
    public String returnInfo() {
        return "Account Manager";
    }
}
