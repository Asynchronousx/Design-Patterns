import java.util.HashMap;
import java.util.Map;

public class Main {

    //Load the handled in the order : vendor -> salesman -> account manager and return the vendor:
    //he'll got all the successors into his attributes.
    static Vendor loadHandlers() {
        Vendor v = new Vendor();
        SalesManager s = new SalesManager();
        AccountManager a = new AccountManager();

        v.setSuccessor(s);
        s.setSuccessor(a);

        return v;

    }

    public static void main(String[] args) {
        Request request = new Request(3999);
        Handler vendor = loadHandlers();

        vendor.handleRequest(request);

    }
}
