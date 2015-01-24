import java.awt.*;

/**
 * The car interface
 */
public interface Car {

    /**
     * Returns the price of the car
     * @return the price of the car
     */
    public double getPrice();

    /**
     * Returns the color of the car
     * @return the color
     */
    public Color getColor();

    /**
     * Returns the number of wheels
     * @return the number of wheels
     */
    public int getNumWheels();
}
