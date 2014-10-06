/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import javax.swing.*;
import java.awt.*;

/**
 * Creates a new game
 * Creates frame
 * @author Rafi Long
 */
public class Main {
    /** The frame */
    public static JFrame frame = new JFrame();
    /** The input */
    public static Input input = new Input();

    /**
     * The game
     */
    public static Game game;

    /**
     * Initializes all methods and begins call cycle
     * @param args
     */
    public static void main(String args[]) {
        initFrame();
        game = new Game();
        Main.setFrameSize();
    }

    /**
     * Initializes the frame
     */
    private static void initFrame() {
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
    public static void setFrameSize() {
        Dimension bounds = frame.getContentPane().getSize();
        double width = bounds.getWidth();
        double height = bounds.getHeight();

        double newWidth;
        double newHeight;

        newWidth = Game.gameWidth + (Game.gameWidth - width);
        newHeight = Game.gameHeight + (Game.gameHeight - height);

        frame.setSize((int) newWidth, (int) newHeight);

    }
}
