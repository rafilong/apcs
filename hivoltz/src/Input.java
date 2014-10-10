/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Gets player input and moves the player
 *
 * @author Rafi Long
 */
public class Input implements KeyListener {
    /**
     * A reference to the Main.game.board object
     */
    private static Grid board;
    /**
     * A reference to the Main.game.board.player object
     */
    private static Cell player;

    /**
     * Constructor adds keylistener to frame
     */
    public Input() {
        Main.frame.addKeyListener(this);
    }

    /**
     * Unused listener
     * @param e key event
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Called when the key is pressed
     * Finds user instructions when the key is pressed
     * @param e key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // you can only move if gameStatus is true
        board = Main.game.board;
        player = Main.game.board.player;

        int character = e.getKeyCode();

        if (Main.game.gameStatus) {
            // Ben and Tyler helped with switch cases
            switch (character) {
                case KeyEvent.VK_Q:
                    move(-1, -1);
                    break;
                case KeyEvent.VK_W:
                    move(0, -1);
                    break;
                case KeyEvent.VK_E:
                    move(1, -1);
                    break;
                case KeyEvent.VK_A:
                    move(-1, 0);
                    break;
                case KeyEvent.VK_S:
                    stay();
                    break;
                case KeyEvent.VK_D:
                    move(1, 0);
                    break;
                case KeyEvent.VK_Z:
                    move(-1, 1);
                    break;
                case KeyEvent.VK_X:
                    move(0, 1);
                    break;
                case KeyEvent.VK_C:
                    move(1, 1);
                    break;
                case KeyEvent.VK_J:
                    jump();
                    break;
            }
        }

        if (character == KeyEvent.VK_R) {
            reset();
        }
    }

    /**
     * Unused listener
     * @param e key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Repaints and calls the next turn methods
     */
    private static void nextTurn() {
        Main.frame.repaint();
        AI.nextTurn();
    }

    /**
     * Resets by calling the Main reset function
     */
    private static void reset() {
        Main.reset();
    }

    /**
     * Makes the player move to a random square on the grid
     */
    private static void jump() {
        // finds a random x and y
        int randomX = (int) (Math.random() * 12.0);
        int randomY = (int) (Math.random() * 12.0);

        // if the x and y has a fence, then jump is recursively called until there isn't a jump on a fence
        if (board.grid[randomX][randomY].getType().equals(Cell.Type.FENCE)) {
            jump();
            return;
        }

        // if the x and y has nothing, the player moves there
        if (board.grid[randomX][randomY].getType().equals(Cell.Type.NOTHING)) {
            // the types of the cell moving to and from being set
            board.grid[randomX][randomY].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            // Main.game.board.player being reset
            Main.game.board.player = board.grid[randomX][randomY];
            // the board repainting
            Main.frame.repaint();

            // note that nextTurn() isn't called because jumping doesn't call for a next turn

        // if there is a mho in the square the player loses
        } else if (board.grid[randomX][randomY].getType().equals(Cell.Type.MHO)) {
            Main.game.playerLoss();
        }
    }

    /**
     * Makes the player move by the specified change in x and y
     *
     * @param changeX moves the number of squares in the x (can be negative)
     * @param changeY moves the number of squares in the y (can be negative)
     */
    private static void move(int changeX, int changeY) {
        // if there is nothing in the square the player is moving to, then it moves
        if (board.grid[player.getX() + changeX][player.getY() + changeY].getType().equals(Cell.Type.NOTHING)) {
            // the types of the cell moving to and from being set
            board.grid[player.getX() + changeX][player.getY() + changeY].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            // Main.game.board.player being reset
            Main.game.board.player = board.grid[player.getX() + changeX][player.getY() + changeY];

            // the next turn is called
            nextTurn();
        // if there is something in the square the player loses
        } else {
            Main.game.playerLoss();
        }
    }

    /**
     * Moves the player nowhere and moves to a new turn
     */
    private static void stay() {
        nextTurn();
    }
}
