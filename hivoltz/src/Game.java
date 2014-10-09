/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import javax.swing.*;
import java.awt.*;

/**
 * Creates the new call cycle and grid
 * Adds grid object to frame
 * @author Rafi Long
 */
public class Game {
    /** The frame */
    public JFrame frame = new JFrame();
    /** The grid */
    public Grid board = new Grid();

    /** The height of the frame */
    public static int gameWidth = Grid.gridWidth * Cell.cellWidth;
    /** The width of the frame */
    public static int gameHeight = Grid.gridHeight * Cell.cellHeight;

    /**
     * Empty constructor
     */
    public Game() {
        initFrame();
//        setFrameSize();
    }

    /**
     * The game ends
     */
    public void gameOver() {
        System.out.println("Game over");
    }

    /**
     * Initializes the frame
     */
    private void initFrame() {
        // initializes the display
        Display display = new Display();

        // sets program to terminate on window close
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // sets the frame to be visible
        frame.setVisible(true);
        // adds the previously created display object to the frame
        frame.add(display);
        // sets the size of the frame to be the game width and height
        frame.setSize(Game.gameWidth, Game.gameHeight);
    }

    /**
     * Sets the size of the frame so it is the correct size inside the border, not including it
     */
    public void setFrameSize() {
        Dimension bounds = frame.getContentPane().getSize();
        double width = bounds.getWidth();
        double height = bounds.getHeight();

        System.out.println(width + " " + height);

        double newWidth;
        double newHeight;

        newWidth = Game.gameWidth + (Game.gameWidth - width);
        newHeight = Game.gameHeight + (Game.gameHeight - height);

        frame.setSize((int) newWidth, (int) newHeight);
    }
}
