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

    /** Whether the game is running or not */
    public boolean gameStatus = true;
    /** If the player won or not */
    public boolean playerWin = false;

    /**
     * Empty constructor
     */
    public Game() {

    }

    /**
     * The player loses the game
     */
    public void playerLoss() {
        System.out.println("Game over");
        Main.frame.repaint();

        gameStatus = false;
        Main.frame.repaint();
    }

    /**
     * The player beats the game
     */
    public void playerWin() {
        System.out.println("You win!");
        Main.frame.repaint();

        gameStatus = false;
        playerWin = true;
        Main.frame.repaint();
    }
}