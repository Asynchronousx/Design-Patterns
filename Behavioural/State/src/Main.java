public class Main {
    public static void main(String args[]) {
        //Declaring a clock
        Clock swatch = new Clock(12,0);
        //State functionality: display time and luminosity
        swatch.doFunctionality();

        //Next state
        swatch.nextMode();

        //State functionality: increase hours by 1
        swatch.doFunctionality();
        swatch.doFunctionality();

        //Next state
        swatch.nextMode();

        //State functionality: increase minute by 1
        swatch.doFunctionality();
        swatch.doFunctionality();

        //Next state: circular goingback to display time and luminosity
        swatch.nextMode();

        //State functionality: display time and luminosity
        swatch.doFunctionality();

    }
}
