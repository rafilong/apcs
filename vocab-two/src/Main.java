import java.awt.*;

/**
 * The main class
 * Used for demonstrating vocabulary
 *
 *
 * Usage of vocabulary words:
 * Inheritance
 *  Inheritance is extending a certain class to create a subclass that has some of the same attributes.
 *  Both Mini and Nissan extend from the Car class.
 *
 * Delegation
 *  Delegation is the act of having a method who's purpose is fulfilled by calling another method through an object.
 *  This is done in the Car class in the numCylinders() method, which is delegated to Engine's getNumCylinders()
 *
 * Polymorphism
 *  Polymorphism is having an object of a superclass, and setting its value to be a subclass of that superclass.
 *  This is done with the myCar field in the Main class, as it is switched from having a value of Mini to Nissan.
 *  It is demonstrated through the toString method, which in Mini does one thing and in Nissan does another.
 *
 * Overloading
 *  Overloading is the act of making to methods with the same name that differ with the type and number of arguments.
 *  This is done in Mini, as it has an overloaded constructor that has 2 arguments that are automatically inferred
 *  from default car types (color and turning signal type)
 */
public class Main {

    /**
     * A main method for testing
     * @param args unused parameter
     */
    public static void main(String args[]) {
        // initialization
        System.out.println("Creating a new Mini Cooper with the default constructor");
        Car myCar = new Mini(1000, new Engine(6, 50), 4, Color.gray, false);
        System.out.println("Here is my car now: " + myCar);
        System.out.println();

        // delegation
        System.out.println("Now I check how many cylinders with Engine.getNumCylinders() using this.numCylinders()");
        System.out.println("I have " + myCar.numCylinders() + " cylinders");
        System.out.println();

        // overloading
        System.out.println("Now I use the overloaded Mini constructor to get the default red and blinky lights");
        myCar = new Mini(1000, new Engine(6, 50), 4);
        System.out.println("Here is my new car: " + myCar);
        System.out.println();

        // polymorphism
        System.out.println("Now I set my car to be a Nissan, as they are cooler than Minis, using polymorphism");
        myCar = new Nissan(100000, new Engine(8, 70), 4, Color.white, true);
        System.out.println("Here is my new Nissan: " + myCar);
        System.out.println();
    }
}
