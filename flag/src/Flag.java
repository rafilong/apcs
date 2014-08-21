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

    private static double smallStripeWidth = 1.14;
    private static double largeStripeWidth = 1.9;
    private static double stripeHeight = 1.0 / 13.0;

    private static double unionWidth = 0.76;
    private static double unionHeight = 7.0 / 13.0;

    private static double starDiameter = 0.0616;
    private static double xStarOffset = 0.063;
    private static double yStarOffset = 0.054;


    /**
     * Initializes everything
     * Repeatedly calls to check if frame size has changed
     * @param args unused parameter
     */
    public static void main(String args[]) {
    }

    public static void initStripes() {

    }

    public static void initUnionBlue() {

    }

    public static void initStars() {

    }
}
