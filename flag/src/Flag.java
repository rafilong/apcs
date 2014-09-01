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
    private static double smallStripeWidth = 1.14;
    /** The width of the larger stripes in relation to the total height */
    private static double largeStripeWidth = 1.9;
    /** The height in relation to the total height */
    private static double stripeHeight = 1.0 / 13.0;

    /** The width of the union in relation to the total height */
    private static double unionWidth = 0.76;

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
        for (int row = 0; row < 13; row++) {
            stripes[row] = new Rectangle(0, stripeHeight * row, largeStripeWidth, stripeHeight);
        }
    }

    /**
     * Adds values to the union object
     */
    private static void initUnionBlue() {
        for (int row = 0; row < 7; row++) {
            unionBlue[row] = new Rectangle(0, stripeHeight * row, unionWidth, stripeHeight);
        }
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
                stars[row * 6 + column] = new Star(xOffset, yOffset, starDiameter);
            }
        }

        //Initializes rows of stars with 5 stars
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 5; column++) {
                double xOffset = xStarOffset * 2 * (column + 1);
                double yOffset = yStarOffset * 2 * (row + 1);
                stars[row * 5 + column + 30] = new Star(xOffset, yOffset, starDiameter);
            }
        }
    }

    /**
     * Finds the scale of the frame
     * @return the height of the flag
     */
    public static double getFrameSize() {
        Dimension bounds = frame.getContentPane().getSize();
        double width = bounds.getWidth();
        double height = bounds.getHeight();

        if (width / height > 1.9) {
            // width is larger than proportion
            Display.centerXOffset = (width - height * 1.9) / 2;
            Display.centerYOffset = 0;
            return height;
        } else {
            // height is larger than proportion
            Display.centerXOffset = 0;
            Display.centerYOffset = (height - width / 1.9) / 2;
            return width / 1.9;
        }
    }
}
