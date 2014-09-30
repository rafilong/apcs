/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import javax.swing.*;
import java.awt.*;

/**
 * Displays the board
 * @author Rafi Long
 */
public class Display extends JComponent {

    /**
     * Empty constructor
     */
    public Display() {

    }

    /**
     * Calls the other paint methods
     * @param g
     */
    public void paint(Graphics g) {
        drawTiles(g);
        drawPlayer(g);
        drawMhos(g);
    }

    /**
     * Draws the empty tiles and fences
     * @param g
     */
    private void drawTiles(Graphics g) {

    }

    /**
     * Draws the player
     * @param g
     */
    private void drawPlayer(Graphics g) {

    }

    /**
     * Draws the mhos
     * @param g
     */
    private void drawMhos(Graphics g) {

    }
}
