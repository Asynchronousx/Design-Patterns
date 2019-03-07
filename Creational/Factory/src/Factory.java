public class Factory  {
    //The factory should not have any attribute, because
    //Its only job is to "Factorize" object from given classes.

    //Theoretically, all the classes and interface above this class
    //should be private to let the client only know about the Factory.
    //But this would overload factory with a lot of code, so a solution
    //would be either 1) create N java file for N classes and interface
    //or 2) create some sort of encapsulation with inner class.

    //Defining a method to "Factorize" the object
    public Animal getObjectNamed(AnimalsType type) {

        switch(type) {
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            default:
                return null;
        }

    }


    //Interfaces and classes
    public interface Animal {
        String getVerse();
    }

    //Defining class that implements product (Concrete Product)
    private class Cat implements Animal {
        @Override
        public String getVerse() {
            return "Miao";
        }
    }

    private class Dog implements Animal {
        @Override
        public String getVerse() {
            return "Bau";
        }
    }

}

enum AnimalsType {
    Cat,
    Dog
}
