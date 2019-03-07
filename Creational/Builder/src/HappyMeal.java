//Abstract product class
interface McDonaldBundleMenu {
    String getFries();
    String getBurger();
    String getBeverage();
    default String getToy() { return null; }

    void setFries(String type);
    void setBurger(String type);
    void setBeverage(String type);
    void setToy(String toy);

}

//Product class
public class HappyMeal implements McDonaldBundleMenu {
    private String fries;
    private String burger;
    private String beverage;
    private String toy;

    //Setter and getter
    public String getFries() {
        return fries;
    }

    public void setFries(String fries) {
        this.fries = fries;
    }

    public String getBurger() {
        return burger;
    }

    public void setBurger(String burger) {
        this.burger = burger;
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }

    @Override
    public String toString() {
        return "Happy meal: [Fries = " + getFries() + ", Burger = " + getBurger() +
                ", Beverage = " + getBeverage() + ", Toy = " + getToy() + "]";
    }
}

//Abstract Builder
interface BundleBuilder {
    McDonaldBundleMenu build();
}

//Concrete Builder: e.g. Worker in the kitchen
class ConcreteHappyMealBuilder implements BundleBuilder {
    //The concrete builder got an instance of the object to build into
    //the class itself: that's because otherwise we should REPLICATE ALL THE INFOS
    //of the instance (e.g: fries, burger ecc): this is a virtual bundle, used only
    //for creating the new one that will return with build.
    HappyMeal virtualHappyMeal;

    //Constructor: we need to init the virtualBundle

    @Override
    public McDonaldBundleMenu build() {
        McDonaldBundleMenu newMeal = virtualHappyMeal;
        return newMeal;
    }

    public ConcreteHappyMealBuilder setFries(String type) {
        this.virtualHappyMeal.setFries(type + " Fries");
        return this;
    }

    public ConcreteHappyMealBuilder setBurger(String type) {
        this.virtualHappyMeal.setBurger(type + " Burger");
        return this;
    }

    public ConcreteHappyMealBuilder setBeverage(String type) {
        this.virtualHappyMeal.setBeverage(type);
        return this;
    }

    public ConcreteHappyMealBuilder setToy(String type) {
        if(type.compareTo(McDonaldToy.getActualToy()) == 0) {
            this.virtualHappyMeal.setToy(type);
        } else {
            System.out.println("Sorry kiddo, u can have only the current toy.");
            this.virtualHappyMeal.setToy(McDonaldToy.getActualToy());
        }
        return this;
    }

    public ConcreteHappyMealBuilder setMeal(HappyMeal meal) {
        this.virtualHappyMeal = meal;
        return this;
    }

}

//Director of the creation: e.g: cashier, give order to the worker.
class Director {
    //Declaring the builder that will build the happy meal.
    static public ConcreteHappyMealBuilder builder = new ConcreteHappyMealBuilder();

    public static McDonaldBundleMenu buildStandardHappyMeal() {
        HappyMeal meal = new HappyMeal();
        return builder
                .setMeal(meal)
                .setFries("Stick")
                .setBurger("Meat")
                .setBeverage("Coca-Cola")
                .setToy(McDonaldToy.getActualToy())
                .build();
    }

}

class McDonaldToy {
    static String actualToy = "Buzz Light Year";

    static public String getActualToy() {
        return actualToy;
    }

}