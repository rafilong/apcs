/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import javax.swing.*;

/**
 * Creates a new game
 * Creates frame
 * @author Rafi Long
 */
public class Main {
    /** The frame */
    public static JFrame frame = new JFrame();

    /**
     * Initializes all methods and begins call cycle
     * @param args
     */
    public static void main(String args[]) {
        initFrame();
    }

    /**
     * Initializes the frame
     */
    private static void initFrame() {
        // creates a new display object
        Display display = new Display();

        // sets program to terminate on window close
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // sets the size of the frame to be 800 by 800
        frame.setSize(800, 800);
        // sets the frame to be visible
        frame.setVisible(true);
        // adds the previously created display object to the frame
        frame.add(display);
    }
}
