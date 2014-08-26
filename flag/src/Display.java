import javax.swing.*;
import java.awt.*;

/**
 * Calls the Rectangle and Star draw functions for all Flag objects
 */
public class Display extends JComponent {
    /** The height of the flag in proportion to frame size */
    public static double flagHeight = 0;

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

        Flag.unionBlue.drawRectangle(g, Color.BLUE);

        for (int i = 0; i < 13; i++) {
            if (i % 2 != 0) {
                Flag.stripes[i].drawRectangle(g, Color.WHITE);
            } else {
                Flag.stripes[i].drawRectangle(g, Color.RED);
            }
        }

//        for (int i = 0; i < 50; i++) {
//            Flag.stars[i].drawStar(g);
//        }
    }
}
