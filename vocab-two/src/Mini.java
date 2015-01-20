import java.awt.*;

/**
 * A class for the Mini Cooper type car
 * Inherits from the Car class and has an overloaded constructor
 */
public class Mini extends Car {
    /** Whether the car has the turning signal on the rear view mirror thing */
    boolean turningSignal;

    /**
     * The default constructor for the Mini Cooper
     *
     * @param price the cost to buy the Mini
     * @param engine the engine
     * @param numWheels the number of wheels
     * @param color the color
     * @param hasRearviewTurningSignal whether it has the rear view mirror turning signal
     */
    public Mini(double price, Engine engine, int numWheels, Color color, boolean hasRearviewTurningSignal) {
        super(price, engine, numWheels, color);
        this.turningSignal = hasRearviewTurningSignal;
    }

    /**
     * An overloaded constructor for the generic Mini Cooper
     * Has a red paint job and the turning signal on the rear view mirror
     *
     * @param price the cost to buy the Mini
     * @param engine the engine
     * @param numWheels the number of wheels
     */
    public Mini(double price, Engine engine, int numWheels) {
        super(price, engine, numWheels, Color.red);
        this.turningSignal = true;
    }

    public String toString() {
        if (turningSignal) {
            return "This Mini Cooper has a rear view mirror turning signal";
        } else {
            return "This Mini Cooper does not have a rear view mirror turning signal";
        }
    }
}
