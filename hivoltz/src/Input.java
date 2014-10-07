/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Gets player input and moves the player
 * @author Rafi Long
 */
public class Input implements KeyListener {
    /** A reference to the Main.game.board object */
    private static Grid board;
    /** A reference to the Main.game.board.player object */
    private static Cell player;

    /**
     * Constructor adds keylistener to frame
     */
    public Input() {
        Main.frame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        board = Main.game.board;
        player = Main.game.board.player;

        int character = e.getKeyCode();

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

    @Override
    public void keyReleased(KeyEvent e) {}

    /**
     * Calls the next turn methods
     */
    private static void nextTurn() {
        AI.nextTurn();
        System.out.println("Next turn");
    }

    /**
     * Makes the player move to a random square on the grid
     */
    private static void jump() {
        int randomX = (int) (Math.random() * 12.0);
        int randomY = (int) (Math.random() * 12.0);

        if (!board.grid[randomX][randomY].getType().equals(Cell.Type.FENCE)) {
            board.grid[randomX][randomY].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[randomX][randomY];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }

    /**
     * Makes the player move in the specified way
     * @param changeX moves the number of squares in the x (can be negative)
     * @param changeY moves the number of squares in the y (can be negative)
     */
    private static void move(int changeX, int changeY) {
        if (board.grid[player.getX() + changeX][player.getY() + changeY].getType().equals(Cell.Type.NOTHING)) {
            board.grid[player.getX() + changeX][player.getY() + changeY].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[player.getX() + changeX][player.getY() + changeY];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }

    /**
     * Moves the player nowhere
     */
    private static void stay() {
        nextTurn();
    }
}
