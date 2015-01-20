import java.awt.*;

/**
 * A Car class that brands inherit from
 */
public class Car {
    /** The price of the car */
    private double price;

    /** The engine used in the car */
    private Engine engine;

    /** The number of wheels on the car */
    private int numWheels;

    /** The color of the car */
    private Color color;

    /**
     * A default constructor for car
     * @param price the price
     * @param engine the engine
     * @param numWheels the number of wheels
     * @param color the color of the car
     */
    public Car(double price, Engine engine, int numWheels, Color color) {
        this.price = price;
        this.engine = engine;
        this.numWheels = numWheels;
        this.color = color;
    }

    /**
     * Returns the price of the car
     * @return the price of the car
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the engine
     * @return the engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Returns the number of cylinders in the car
     * This method is delegated to the engine subclass through the use of
     *  the private object engine
     * @return the number of cylinders
     */
    public int numCylinders() {
        return engine.getNumCylinders();
    }

    /**
     * Sets the engine to a new engine
     * @param engine the engine to replace the old one
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * Returns the number of wheels
     * @return the number of wheels
     */
    public int getNumWheels() {
        return numWheels;
    }

    /**
     * Returns the color of the car
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the car to a new color
     * @param color the color to be set to
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
