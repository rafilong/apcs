/*
 * Cow Project
 * Written by Rafi Long
 *
 * See code for documentation
 * Description of classes and methods are included in JavaDocs
 */

import javax.swing.*;

/**
 * Main method
 * Creates display object and frame
 * Adds display to frame
 */
public class Main {

    /**
     * Creates a frame and adds the display to the frame
     * @param args
     */
    public static void main(String args[]) {
        //creates a new display object
        Display display = new Display();

        //creates a new frame
        JFrame frame = new JFrame();
        //sets program to terminate on window close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the size of the frame to by 400 by 400
        frame.setSize(400, 400);
        //sets the frame to be visible
        frame.setVisible(true);
        //adds the previously created display object to the frame
        frame.add(display);
    }
}