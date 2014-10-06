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

        if (character == KeyEvent.VK_Q) {
            moveUpLeft();
        } else if (character == KeyEvent.VK_W) {
            moveUp();
        } else if (character == KeyEvent.VK_E) {
            moveUpRight();
        } else if (character == KeyEvent.VK_A) {
            moveLeft();
        } else if (character == KeyEvent.VK_S) {
            stay();
        } else if (character == KeyEvent.VK_D) {
            moveRight();
        } else if (character == KeyEvent.VK_Z) {
            moveDownLeft();
        } else if (character == KeyEvent.VK_X) {
            moveDown();
        } else if (character == KeyEvent.VK_C) {
            moveDownRight();
        } else if (character == KeyEvent.VK_J) {
            jump();
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

    private static void jump() {
        int randomX = (int) (Math.random() * 12.0);
        int randomY = (int) (Math.random() * 12.0);

        if (board.grid[randomX][randomY].getType().equals(Cell.Type.NOTHING)) {
            board.grid[randomX][randomY].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[randomX][randomY];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }

    /**
     * Moves the player up and to the left
     */
    private static void moveUpLeft() {
        if (board.grid[player.getX() - 1][player.getY() - 1].getType().equals(Cell.Type.NOTHING)) {
            board.grid[player.getX() - 1][player.getY() - 1].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[player.getX() - 1][player.getY() - 1];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }

    /**
     * Moves the player up
     */
    private static void moveUp() {
        if (board.grid[player.getX()][player.getY() - 1].getType().equals(Cell.Type.NOTHING)) {
            board.grid[player.getX()][player.getY() - 1].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[player.getX()][player.getY() - 1];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }

    /**
     * Moves the player up and to the right
     */
    private static void moveUpRight() {
        if (board.grid[player.getX() + 1][player.getY() - 1].getType().equals(Cell.Type.NOTHING)) {
            board.grid[player.getX() + 1][player.getY() - 1].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[player.getX() + 1][player.getY() - 1];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }

    /**
     * Moves the player left
     */
    private static void moveLeft() {
        if (board.grid[player.getX() - 1][player.getY()].getType().equals(Cell.Type.NOTHING)) {
            board.grid[player.getX() - 1][player.getY()].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[player.getX() - 1][player.getY()];

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

    /**
     * Moves the player right
     */
    private static void moveRight() {
        if (board.grid[player.getX() + 1][player.getY()].getType().equals(Cell.Type.NOTHING)) {
            board.grid[player.getX() + 1][player.getY()].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[player.getX() + 1][player.getY()];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }

    /**
     * Moves the player down and to the left
     */
    private static void moveDownLeft() {
        if (board.grid[player.getX() - 1][player.getY() + 1].getType().equals(Cell.Type.NOTHING)) {
            board.grid[player.getX() - 1][player.getY() + 1].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[player.getX() - 1][player.getY() + 1];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }

    /**
     * Moves the player down
     */
    private static void moveDown() {
        if (board.grid[player.getX()][player.getY() + 1].getType().equals(Cell.Type.NOTHING)) {
            board.grid[player.getX()][player.getY() + 1].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[player.getX()][player.getY() + 1];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }

    /**
     * Moves the player down and to the right
     */
    private static void moveDownRight() {
        if (board.grid[player.getX() + 1][player.getY() + 1].getType().equals(Cell.Type.NOTHING)) {
            board.grid[player.getX() + 1][player.getY() + 1].setType(Cell.Type.PLAYER);
            board.grid[player.getX()][player.getY()].setType(Cell.Type.NOTHING);

            Main.game.board.player = board.grid[player.getX() + 1][player.getY() + 1];

            nextTurn();
        } else {
            Main.game.gameOver();
        }
    }
}
