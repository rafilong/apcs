import java.awt.*;

/**
 * A class for the Mini Cooper type car
 * Inherits from the Car class
 */
public class Nissan extends Car {
    /** Whether the car has nitrous or not */
    boolean hasNitrous;

    /**
     * The default constructor
     *
     * @param price the price of the car
     * @param engine the engine
     * @param numWheels the number of wheels
     * @param color the color
     * @param hasNitrous whether the car has nitrous or not
     */
    public Nissan(double price, Engine engine, int numWheels, Color color, boolean hasNitrous) {
        super(price, engine, numWheels, color);
        this.hasNitrous = hasNitrous;
    }

    /**
     * Returns if the car has nitrous or not
     * @return whether there is nitrous or not
     */
    public boolean hasNitrous() {
        return hasNitrous;
    }

    /**
     * Sets whether the car has nitrous or not
     * @param hasNitrous whether the car has nitrous or not
     */
    public void setNitrous(boolean hasNitrous) {
        this.hasNitrous = hasNitrous;
    }

    public String toString() {
        if (hasNitrous) {
            return "This Nissan has nitrous";
        } else {
            return "This Nissan does not have nitrous";
        }
    }
}
