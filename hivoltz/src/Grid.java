/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import java.util.ArrayList;

/**
 * Initializes all the cells in the grid
 * @author Rafi Long
 */
public class Grid {
    public static int gridWidth = 12;

    public static int gridHeight = 12;

    /** A reference to the cell that contains the player */
    public Cell player;
    /** A reference to the cells with mhos */
    public ArrayList<Cell> mhos = new ArrayList<Cell>();
    /** All of the objects in the grid */
    public Cell[][] grid = new Cell[12][12];

    /**
     * A constructor that calls all of the initiative methods
     */
    public Grid() {
        initCells();
        initFences();
        initPlayer();
        initMhos();
    }

    /**
     * Initializes the cell objects
     */
    public void initCells() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                grid[i][j] = new Cell(Cell.Type.NOTHING, i, j);
            }
        }
    }

    /**
     * Creates fences around the edge
     * Randomly spawns the other 20 fences
     */
    public void initFences() {
        // initializes fences on top and bottom
        for (int i = 0; i < 12; i++) {
            grid[i][0].setType(Cell.Type.FENCE);
            grid[i][11].setType(Cell.Type.FENCE);
        }

        // initializes fences on left and right
        for (int i = 1; i < 11; i++) {
            grid[0][i].setType(Cell.Type.FENCE);
            grid[11][i].setType(Cell.Type.FENCE);
        }

        // initializes random fences
        for (int i = 0; i < 20; i++) {
            // finds random x and y coordinates between 0 and 12
            int x = (int)(Math.random() * 12.0);
            int y = (int)(Math.random() * 12.0);

            // checks if there is something in the cell
            if (grid[x][y].getType().equals(Cell.Type.NOTHING)) {
                grid[x][y].setType(Cell.Type.FENCE);
            // if there is, it doesn't set and adds the number of trials
            } else {
                i--;
            }
        }
    }

    /**
     * Randomly spawns the player in a space with no fence
     */
    public void initPlayer() {
        // initializes random player
        for (int i = 0; i < 1; i++) {
            // finds random x and y coordinates between 0 and 12
            int x = (int)(Math.random() * 12.0);
            int y = (int)(Math.random() * 12.0);

            // checks if there is something in the cell
            if (grid[x][y].getType().equals(Cell.Type.NOTHING)) {
                grid[x][y].setType(Cell.Type.PLAYER);
                player = grid[x][y];
                // if there is, it doesn't set and adds the number of trials
            } else {
                i--;
            }
        }
    }

    /**
     * Randomly spawns the 12 mhos in spaces that don't have a player or a fence
     */
    public void initMhos() {
        // initializes random mhos
        for (int i = 0; i < 12; i++) {
            // finds random x and y coordinates between 0 and 12
            int x = (int)(Math.random() * 12.0);
            int y = (int)(Math.random() * 12.0);

            // checks if there is something in the cell
            if (grid[x][y].getType().equals(Cell.Type.NOTHING)) {
                grid[x][y].setType(Cell.Type.MHO);
                mhos.add(grid[x][y]);
            // if there is, it doesn't set and adds the number of trials
            } else {
                i--;
            }
        }
    }

    /**
     * Finds the mhos and sets them to be in the array
     */
    public void findMhos() {
        // clears the list of mhos
        mhos.clear();

        // if there is a mho in the cell, the cell is added to mhos
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid.length; c++) {
                mhos.add(grid[r][c]);
            }
        }
    }
}