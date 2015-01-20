/**
 * An engine for a car
 */
public class Engine {
    /** The number of cylinders in the engine */
    private int numCylinders;

    /** The weight of the engine */
    private double weight;

    /**
     * A default constructor for engine
     * @param numCylinders the number of cylinders
     * @param weight the weight of the engine
     */
    public Engine(int numCylinders, double weight) {
        this.numCylinders = numCylinders;
        this.weight = weight;
    }

    /**
     * The Car class delegates to this method
     * @return the number of cylinders in the engine
     */
    public int getNumCylinders() {
        return numCylinders;
    }

    /**
     * Unused in this example, but fills it out
     * @return the weight of the engine
     */
    public double getWeight() {
        return weight;
    }
}
