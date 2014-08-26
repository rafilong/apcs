import javax.swing.*;
import java.awt.*;

/**
 * Contains all Rectangle and Star objects
 */
public class Flag {
    /** The frame */
    public static JFrame frame = new JFrame();

    /** The 13 strips in the flag */
    public static Rectangle[] stripes = new Rectangle[13];
    /** The blue rectangle on the union */
    public static Rectangle unionBlue;
    /** The 50 stars on the flag */
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
        initStripes();
        initUnionBlue();
        initStars();

        initFrame();
    }

    /**
     * Initializes the frame
     */
    private static void initFrame() {
        //creates a new display object
        Display display = new Display();

        //sets program to terminate on window close
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //sets the size of the frame to by 400 by 400
        frame.setSize(1140, 600);
        //sets the frame to be visible
        frame.setVisible(true);
        //adds the previously created display object to the frame
        frame.add(display);
    }

    /**
     * Adds values to all of the stripe objects
     */
    private static void initStripes() {
        for (int i = 0; i < 7; i++) {
            stripes[i] = new Rectangle(unionWidth, stripeHeight * i, smallStripeWidth, stripeHeight);
        }
        for (int i = 7; i < 13; i++) {
            stripes[i] = new Rectangle(0, stripeHeight * i, largeStripeWidth, stripeHeight);
        }
    }

    /**
     * Adds values to the union object
     */
    private static void initUnionBlue() {
        unionBlue = new Rectangle(0, 0, unionWidth, unionHeight);
    }

    /**
     * Adds values to the star objects
     */
    private static void initStars() {

    }

    /**
     * Finds the scale of the frame
     * @return the height of the flag
     */
    public static double getFrameSize() {
        Dimension bounds = frame.getContentPane().getSize();
        if (bounds.getWidth() / bounds.getHeight() > 1.9) {
            return bounds.getHeight();
        } else {
            return bounds.getWidth() / 1.9;
        }
    }
}
