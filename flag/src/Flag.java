/**
 * Contains all Rectangle and Star objects
 */
public class Flag {
    /**
     * The 13 strips in the flag
     */
    public static Rectangle[] stripes = new Rectangle[13];

    /**
     * The blue rectangle on the union
     */
    public static Rectangle unionBlue;

    /**
     * The 50 stars on the flag
     */
    public static Star[] stars = new Star[50];

    /** The width of the smaller stripes in relation to the total height */
    private static double smallStripeWidth = 1.14;
    /** The width of the larger stripes in relation to the total height */
    private static double largeStripeWidth = 1.9;
    /** The height in relation to the total height */
    private static double stripeHeight = 1.0 / 13.0;

    /** The width of the union in relation to the total height */
    private static double unionWidth = 0.76;
    /** The height of the union in relation to the total height */
    private static double unionHeight = 7.0 / 13.0;

    /** The diameter of the star in relation to the total height */
    private static double starDiameter = 0.0616;
    /** The offset of the star on the x axis in relation to the total height */
    private static double xStarOffset = 0.063;
    /** The offset of the star on the y axis in relation to the total height */
    private static double yStarOffset = 0.054;


    /**
     * Initializes everything
     * Repeatedly calls to check if frame size has changed
     * @param args unused parameter
     */
    public static void main(String args[]) {

    }

    /**
     * Adds values to all of the stripe objects
     */
    public static void initStripes() {

    }

    /**
     * Adds values to the union object
     */
    public static void initUnionBlue() {

    }

    /**
     * Adds values to the star objects
     */
    public static void initStars() {

    }
}
