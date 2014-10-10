/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Displays the board
 * @author Rafi Long
 *
 * Colors taken from:
 * http://www.colourlovers.com/palette/2229427/Android_Holo_Light
 * http://www.colourlovers.com/palette/1392493/Android
 * http://developer.android.com/design/style/color.html
 */
public class Display extends JComponent {
    /** The image displayed on a win */
    BufferedImage win;
    /** The image displayed on a loss */
    BufferedImage lose;

    /**
     * Empty constructor
     */
    public Display() {
        // sets the size of the display
        setSize(Game.gameWidth, Game.gameHeight);

        // loads the win and loss images
        try {
            win = ImageIO.read(new File("win.png"));
            lose = ImageIO.read(new File("lose.png"));
        } catch (IOException e) {
            System.err.println("Failed to load images. Game will print out 'Game over' when lost, 'You win' when won");
        }
    }

    /**
     * Calls the other paint methods
     * @param g graphics variable
     */
    public void paint(Graphics g) {
        // draws the grid and the tiles
        drawGrid(g);
        drawTiles(g);

        // if the game is over, then it prints either the win or loss image
        if (!Main.game.gameStatus) {
            if (Main.game.playerWin) {
                g.drawImage(win, 0, 0, this);
            } else {
                g.drawImage(lose, 0, 0, this);
            }
        }
    }

    /**
     * Draws the grid with tile colors
     * @param g graphics variable
     */
    private void drawGrid(Graphics g) {
        // draws the background color (the lines between the cells)
        g.setColor(new Color(0x313131));
        g.fillRect(0, 0, Game.gameWidth, Game.gameHeight);

        // draws the empty cells
          // non-empty cells draw over these
        g.setColor(new Color(0x464D5C));
        for (int r = 0; r < Main.game.board.grid.length; r++) {
            for (int c = 0; c < Main.game.board.grid.length; c++) {
                drawSquareInGrid(g, r, c);
            }
        }
    }

    /**
     * Draws the empty tiles and fences
     * @param g graphics variable
     */
    private void drawTiles(Graphics g) {
        // creates a reference to the board to allow shorting invocations
        Grid board = Main.game.board;

        // loops through all of the tiles, calling the appropriate draw functions for each type of cell
        for (int r = 0; r < board.grid.length; r++) {
            for (int c = 0; c < board.grid.length; c++) {
                if (board.grid[r][c].getType() == Cell.Type.FENCE) {
                    drawFence(g, r, c);
                } else if (board.grid[r][c].getType() == Cell.Type.PLAYER) {
                    drawPlayer(g, r, c);
                } else if (board.grid[r][c].getType() == Cell.Type.MHO) {
                    drawMho(g, r, c);
                }
            }
        }
    }

    /**
     * Draws a fence by setting the appropriate color and calling drawSquareInGrid
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawFence(Graphics g, int row, int col) {
        g.setColor(new Color(0x669900));
        drawSquareInGrid(g, row, col);
    }

    /**
     * Draws a player by setting the appropriate color and calling drawCircleInGrid
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawPlayer(Graphics g, int row, int col) {
        g.setColor(new Color(0x33B5E5));
        drawCircleInGrid(g, row, col);
    }

    /**
     * Draws a mho by setting the appropriate color and calling drawCircleInGrid
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawMho(Graphics g, int row, int col) {
        g.setColor(new Color(0x99CC00));
        drawCircleInGrid(g, row, col);
    }

    /**
     * Draws a square at the appropriate row and column place
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawSquareInGrid(Graphics g, int row, int col) {
        // 2 is the offset for the line, -4 is the offset for both sides
          // (moving the square 2 to one side means making it 4 smaller
        g.fillRect(2 + row * Cell.cellWidth, 2 + col * Cell.cellHeight, Cell.cellWidth - 4, Cell.cellHeight - 4);
    }

    /**
     * Draws a circle at the appropriate row and column place
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawCircleInGrid(Graphics g, int row, int col) {
        // 2 is the offset for the line, -4 is the offset for both sides
          // (moving the square 2 to one side means making it 4 smaller
        g.fillOval(2 + row * Cell.cellWidth, 2 + col * Cell.cellHeight, Cell.cellWidth - 4, Cell.cellHeight - 4);
    }
}