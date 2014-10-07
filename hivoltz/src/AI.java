/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

import java.util.ArrayList;

/**
 * Controls when the mhos move
 * @author Rafi Long
 */
public class AI {
    /** A reference to the Main.game.board object */
    private static Grid board;
    /** A reference to the Main.game.board.player object */
    private static Cell player;
    /** A reference to the Main.game.mhos object */
    private static Cell[] mhos;

    /**
     * Sets the local variables of the cells to be equal to the original values
     * (Ben helped with the conversion of the ArrayList to the array)
     */
    public static void nextTurn() {
        board = Main.game.board;
        player = Main.game.board.player;

        Object[] cand =  Main.game.board.mhos.toArray();

        Cell[] mhosArray = new Cell[cand.length];

        for(int i = 0; i < cand.length; i ++)
        {
            mhosArray[i] = (Cell)(cand[i]);
        }

        mhos = mhosArray;

        findMoves();

        Main.frame.repaint();
        Main.game.board.findMhos();
    }

    private static void findMoves() {
        // calls findMove for all of the mhos
        for (Cell mho : mhos) {
            findMove(mho);
        }
    }

    private static void findMove(Cell mho) {
        // if the mho and the player are in a line, the mho moves towards the player
        if (player.getX() - mho.getX() == 0) {
            moveDirection(mho);
            return;
        } else if (player.getY() - mho.getY() == 0) {
            moveDirection(mho);
            return;
        }

        // if diagonal move will have to move on a fence or mho, then it returns false and tries to move vertically
        if (!moveDirection(mho, Cell.Type.FENCE, Cell.Type.MHO)) {
            // if the player is further or equal horizontally, then it tries to move horizontally
            if (player.getX() - mho.getX() >= player.getY() - mho.getY()) {
                if (moveDirection(mho, Cell.Type.FENCE, Cell.Type.MHO)) {
                    return;
                }
            // if the player is further vertically, then it tries to move vertically
            } else {
                if (moveDirection(mho, Cell.Type.FENCE, Cell.Type.MHO)) {
                    return;
                }
            }
        // if diagonal move did work, then it returns
        } else {
            return;
        }

        // if diagonal move will have to move on a fence or mho, then it returns false and tries to move vertically
        if (!moveDirection(mho, Cell.Type.MHO)) {
            // if the player is further or equal horizontally, then it tries to move horizontally
            if (player.getX() - mho.getX() >= player.getY() - mho.getY()) {
                moveDirection(mho, Cell.Type.MHO);
                // if the player is further vertically, then it tries to move vertically
            } else {
                moveDirection(mho, Cell.Type.MHO);
            }
        }
        // if diagonal move did work, then it will just move diagonal
    }

    private static boolean moveDirection(Cell mho, Cell.Type ... types) {
        // change in x direction to move towards the player
        int changeX;
        // change in y direction to move towards the player
        int changeY;

        // if the player is on the left
        if (player.getX() < mho.getX()) {
            changeX = -1;
        // if the player is on the right
        } else {
            changeX = 1;
        }

        // if the player is above
        if (player.getY() < mho.getY()) {
            changeY = -1;
            // if the player below
        } else {
            changeY = 1;
        }

        // if one of the types is in the way, it returns false
        for (Cell.Type type : types) {
            if (board.grid[mho.getX() + changeX][mho.getY() + changeY].getType().equals(type)) {
                return false;
            }
        }

        // moves the mho towards the player and returns true
        move(mho, changeX, changeY);
        return true;
    }

    private static void move(Cell mho, int changeX, int changeY) {
        board.grid[mho.getX() + changeX][mho.getY() + changeY].setType(Cell.Type.MHO);
        board.grid[mho.getX()][mho.getY()].setType(Cell.Type.NOTHING);
    }
}
