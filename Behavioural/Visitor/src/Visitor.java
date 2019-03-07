import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Visitor {
    void visit(AcmeMarket a);
    void visit(Walmart w);
}

class KellogsStand implements Visitor {

    @Override
    public void visit(Walmart w) {
        System.out.println("Kellogs stand at Walmart: ");
        System.out.println("Normal Kellogs price: " + w.Products.get("Kellogs"));
        System.out.println("Special Price at Kellogs stand: " + (w.Products.get("Kellogs")-1));
        System.out.println();
    }

    @Override
    public void visit(AcmeMarket a) {
        System.out.println("Kellogs stand at Acme: ");
        System.out.println("Normal Kellogs price: " + a.Products.get("Kellogs"));
        System.out.println("Special Price at Kellogs stand: " + (a.Products.get("Kellogs")-2));
        System.out.println();
    }
}

class HeinzStand implements Visitor {

    @Override
    public void visit(Walmart w) {
        System.out.println("Heinz stand at Walmart: ");
        System.out.println("Normal Heinz price: " + w.Products.get("Heinz"));
        System.out.println("Special Price at Heinz stand: " + (w.Products.get("Heinz")-2));
        System.out.println();
    }

    @Override
    public void visit(AcmeMarket a) {
        System.out.println("Heinz stand at Acme: ");
        System.out.println("Normal Heinz price: " + a.Products.get("Heinz"));
        System.out.println("Special Price at Heinz stand at Acme: " + (a.Products.get("Kellogs")-1));
        System.out.println();
    }
}

interface Element {
    void accept(Visitor v);
}

class SuperMarket implements Element {

    List<Element> superMarketList = new ArrayList<>();

    @Override
    public void accept(Visitor v) {
        for(Element e: superMarketList) {
            e.accept(v);
        }
    }
}

class AcmeMarket implements Element {

    protected Map<String, Integer> Products;

    public AcmeMarket() {
        this.Products = new HashMap<>();
        loadSampleProducts();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public void loadSampleProducts() {
        this.Products.put("Campbell", 10);
        this.Products.put("Pepsi", 2);
        this.Products.put("Kellogs", 8);
        this.Products.put("Heinz", 5);
        this.Products.put("Coca-Cola", 2);
    }
}

class Walmart implements Element {

    protected Map<String, Integer> Products;

    public Walmart() {
        this.Products = new HashMap<>();
        loadSampleProducts();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public void loadSampleProducts() {
        this.Products.put("Campbell", 10);
        this.Products.put("Pepsi", 2);
        this.Products.put("Kellogs", 8);
        this.Products.put("Heinz", 5);
        this.Products.put("Coca-Cola", 2);
    }
}


