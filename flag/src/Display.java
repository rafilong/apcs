import javax.swing.*;
import java.awt.*;

/**
 * Calls the Rectangle and Star draw functions for all Flag objects
 */
public class Display extends JComponent {
    /** The width of the frame */
    public static double frameWidth = 0;
    /** The height of the frame */
    public static double frameHeight = 0;

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
        double height = Flag.getFrameSize();

        Flag.unionBlue.drawRectangle(g);

        for (int i = 0; i < 13; i++) {
            Flag.stripes[i].drawRectangle(g);
        }

//        for (int i = 0; i < 50; i++) {
//            Flag.stars[i].drawStar(g);
//        }

        System.out.println("Frame height is: " + height);
        System.out.println();
    }
}
