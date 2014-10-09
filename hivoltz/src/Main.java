/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import javax.swing.*;
import java.awt.*;

/**
 * Creates a new game and input
 * @author Rafi Long
 */
public class Main {
    /** The input */
    public static Input input;
    /** The game */
    public static Game game;

    /**
     * Initializes all methods and begins call cycle
     * @param args unused parameter
     */
    public static void main(String args[]) {
        game = new Game();
        input = new Input();
    }
}
