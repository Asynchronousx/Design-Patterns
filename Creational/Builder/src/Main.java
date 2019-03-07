public class Main {
    public static void main(String[] args) {

        //Building a stabdard happy meal
        McDonaldBundleMenu happyMeal = Director.buildStandardHappyMeal();
        System.out.println(happyMeal);

        //Building a custom happy meal
        HappyMeal meal = new HappyMeal();
        McDonaldBundleMenu happyMealCustom = Director.builder
                .setMeal(meal)
                .setFries("Curly")
                .setBurger("Chicken")
                .setBeverage("Fanta")
                .setToy("Pokemon")
                .build();

        System.out.println(happyMealCustom);
        System.out.println(happyMeal);

    }
}
