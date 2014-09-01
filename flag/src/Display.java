/*
 * AP Computer Science Flag Project
 * Code written by Rafi Long
 * See code for documentation
 */

import javax.swing.*;
import java.awt.*;

/**
 * Calls the Rectangle and Star draw functions for all Flag objects
 * Extends the JComponent
 */
public class Display extends JComponent {
    /** The height of the flag in proportion to frame size */
    public static double flagHeight = 0;
    /** The amount to offset the X in order to keep the flag centered */
    public static double centerXOffset = 0;
    /** The amount to offset the Y in order to keep the flag centered */
    public static double centerYOffset = 0;

    /**
     * Empty constructor
     */
    public Display() {

    }

    /**
     * Finds frame width
     * Calls the rectangle and star draw functions
     * @param g
     */
    public void paint(Graphics g) {
        flagHeight = Flag.getFrameSize();

        // Calls the stripe draw function
        for (int i = 0; i < 13; i++) {
            // Alternates colors for each stripe
            if (i % 2 != 0) {
                Flag.stripes[i].drawRectangle(g, new Color(0xffffff));
            } else {
                Flag.stripes[i].drawRectangle(g, new Color(0xb22234));
            }
        }


        // Calls the union draw function
        // The union is divided into 7 parts in order to avoid rounding errors exposed by graphics
        for (int i = 0; i < 7; i++) {
            Flag.unionBlue[i].drawRectangle(g, new Color(0x3c3b6e));
        }

        // Calls the star draw function
        for (int i = 0; i < 50; i++) {
            Flag.stars[i].drawStar(g, new Color(0xffffff));
        }
    }
}
