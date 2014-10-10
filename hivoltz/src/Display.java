/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import javax.swing.*;
import java.awt.*;

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

    /**
     * Empty constructor
     */
    public Display() {
        setSize(Game.gameWidth, Game.gameHeight);
    }

    /**
     * Calls the other paint methods
     * @param g
     */
    public void paint(Graphics g) {
        // draws the grid and the tiles
        drawGrid(g);
        drawTiles(g);

        // checks to see if there is a mho that killed the player
        if (AI.mhoKiller != null) {
            drawMhoKiller(g, AI.mhoKiller.getX(), AI.mhoKiller.getY());
        }
    }

    /**
     * Draws the empty tiles and fences
     * @param g
     */
    private void drawTiles(Graphics g) {
        Grid board = Main.game.board;

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
     * Draws the grid with tile colors
     * @param g
     */
    private void drawGrid(Graphics g) {
        g.setColor(new Color(0x313131));
        g.fillRect(0, 0, Game.gameWidth, Game.gameHeight);

        g.setColor(new Color(0x464D5C));
        for (int r = 0; r < Main.game.board.grid.length; r++) {
            for (int c = 0; c < Main.game.board.grid.length; c++) {
                drawSquareInGrid(g, r, c);
            }
        }
    }

    /**
     * Draws a fence
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawFence(Graphics g, int row, int col) {
        g.setColor(new Color(0x669900));
        drawSquareInGrid(g, row, col);
    }

    /**
     * Draws a player
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawPlayer(Graphics g, int row, int col) {
        g.setColor(new Color(0x33B5E5));
        drawCircleInGrid(g, row, col);
    }

    /**
     * Draws a mho
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawMho(Graphics g, int row, int col) {
        g.setColor(new Color(0x99CC00));
        drawCircleInGrid(g, row, col);
    }

    /**
     * Draws the mho that killed the player in red
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    public void drawMhoKiller(Graphics g, int row, int col) {
        g.setColor(new Color(0xFF4444));
        drawCircleInGrid(g, row, col);
    }

    /**
     * Draws a square
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawSquareInGrid(Graphics g, int row, int col) {
        g.fillRect(2 + row * Cell.cellWidth, 2 + col * Cell.cellHeight, Cell.cellWidth - 4, Cell.cellHeight - 4);
    }

    /**
     * Draws a circle
     * @param g graphics variable
     * @param row the row the object is in
     * @param col the column the object is in
     */
    private void drawCircleInGrid(Graphics g, int row, int col) {
        g.fillOval(2 + row * Cell.cellWidth, 2 + col * Cell.cellHeight, Cell.cellWidth - 4, Cell.cellHeight - 4);
    }
}
