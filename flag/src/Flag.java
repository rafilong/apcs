/*
 * AP Computer Science Flag Project
 * Code written by Rafi Long
 * See code for documentation
 */

import javax.swing.*;
import java.awt.*;

/**
 * Contains all Rectangle and Star objects
 * Finds the offset of the flag to keep the flag centered
 */
public class Flag {
    /** The frame */
    public static JFrame frame = new JFrame();

    /** The 13 strips in the flag */
    public static Rectangle[] stripes = new Rectangle[13];
    /** The blue rectangle on the union */
    public static Rectangle[] unionBlue = new Rectangle[7];
    /** The 50 stars on the flag */
    public static Star[] stars = new Star[50];

    /** The width of the smaller stripes in relation to the total height */
    private static final double smallStripeWidth = 1.14;
    /** The width of the larger stripes in relation to the total height */
    private static final double largeStripeWidth = 1.9;
    /** The height in relation to the total height */
    private static final double stripeHeight = 1.0 / 13.0;

    /** The width of the union in relation to the total height */
    private static final double unionWidth = 0.76;

    /** The diameter of the star in relation to the total height */
    private static final double starDiameter = 0.0616;
    /** The offset of the star on the x axis in relation to the total height */
    private static final double xStarOffset = 0.063;
    /** The offset of the star on the y axis in relation to the total height */
    private static final double yStarOffset = 0.054;


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
        // The stripes don't have to be separated by color, as the color is not coded into the object, and is instead
        //  created by the paint function in the Display class
        for (int row = 0; row < 13; row++) {
            if (row % 2 != 0) {
                stripes[row] = new Rectangle(0, stripeHeight * row, largeStripeWidth, stripeHeight, new Color(0xffffff));
            } else {
                stripes[row] = new Rectangle(0, stripeHeight * row, largeStripeWidth, stripeHeight, new Color(0xb22234));
            }
        }
    }

    /**
     * Adds values to the union object
     */
    private static void initUnionBlue() {
        // The union is divided into 7 parts in order to avoid rounding errors exposed by graphics
        // The first 6 parts are initialized first with a larger height in order to avoid white space between stripes
        for (int row = 0; row < 6; row++) {
            unionBlue[row] = new Rectangle(0,  stripeHeight * row, unionWidth, stripeHeight + 0.01, new Color(0x3c3b6e));
        }
        unionBlue[6] = new Rectangle(0,  stripeHeight * 6, unionWidth, stripeHeight, new Color(0x3c3b6e));
    }

    /**
     * Adds values to the star objects
     */
    private static void initStars() {
        // Initializes rows of stars with 6 stars
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 6; column++) {
                double xOffset = xStarOffset + xStarOffset * 2 * column;
                double yOffset = yStarOffset + yStarOffset * 2 * row;
                stars[row * 6 + column] = new Star(xOffset, yOffset, starDiameter, new Color(0xffffff));
            }
        }

        //Initializes rows of stars with 5 stars
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 5; column++) {
                double xOffset = xStarOffset * 2 * (column + 1);
                double yOffset = yStarOffset * 2 * (row + 1);
                stars[row * 5 + column + 30] = new Star(xOffset, yOffset, starDiameter, new Color(0xffffff));
            }
        }
    }

    /**
     * Finds the scale of the frame
     * @return the height of the flag
     */
    public static double getFrameSize() {
        // Finds the width and the height of the frame
        /* Tyler helped with choosing between using .getFrame and .getContent Pane */
        Dimension bounds = frame.getContentPane().getSize();
        double width = bounds.getWidth();
        double height = bounds.getHeight();

        if (width / height > 1.9) {
            // if the width is larger than proportion, then the XOffset is set to make the x in proportion to the y
            Display.centerXOffset = (width - height * 1.9) / 2;
            Display.centerYOffset = 0;
            return height;
        } else {
            // if the height is larger than proportion, then the YOffset is set to make the y in proportion to the x
            Display.centerXOffset = 0;
            Display.centerYOffset = (height - width / 1.9) / 2;
            return width / 1.9;
        }
    }
}
