import java.awt.*;

/**
 * A class for the Mini Cooper type car
 * Implements the Car class
 */
public class Mini implements Car {
    /** Whether the car has the turning signal on the rear view mirror thing */
    boolean turningSignal;

    /** The price of the car */
    double price;

    /** The number of wheels */
    int numWheels;

    /** The color, and if there is a turning signal thing, then the color must be red */
    Color color;

    /**
     * The default constructor for the Mini Cooper
     *
     * @param price the cost to buy the Mini
     * @param numWheels the number of wheels
     * @param color the color
     * @param hasRearviewTurningSignal whether it has the rear view mirror turning signal
     */
    public Mini(double price, int numWheels, Color color, boolean hasRearviewTurningSignal) {
        this.turningSignal = hasRearviewTurningSignal;
        this.price = price;
        this.numWheels = numWheels;
        this.color = color;
        if (turningSignal) this.color = Color.red;
    }

    public String toString() {
        if (turningSignal) {
            return "This Mini Cooper has a rear view mirror turning signal and is " + color;
        } else {
            return "This Mini Cooper does not have a rear view mirror turning signal and is " + color;
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getNumWheels() {
        return numWheels;
    }
}