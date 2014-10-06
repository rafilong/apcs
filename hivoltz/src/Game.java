/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

/**
 * Creates the new call cycle and grid
 * @author Rafi Long
 */
public class Game {
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

    }

    /**
     * The game ends
     */
    public void gameOver() {
        System.out.println("Game over");
    }
}
