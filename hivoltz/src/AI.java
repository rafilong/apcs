/*
 * AP Computer Science Hivoltz Project
 * Code written by Rafi Long
 * See code for documentation
 */

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
        // sets board and player to reference Main.game.board variables
        board = Main.game.board;
        player = Main.game.board.player;

        // sets mhos to reference Main.game.board.mhos, but converts it to an array from an ArrayList
        setMhos();

        // finds all the moves for the mhos
        findMoves();

        // repaints the board
        Main.frame.repaint();
        // resets mhos in Main.game.board
        Main.game.board.findMhos();
    }

    /**
     * Adds the objects in the Grid.mhos to the AI.mhos
     */
    private static void setMhos() {
        // a new Object array for mhos
        Object[] cand =  Main.game.board.mhos.toArray();

        // creates a new Cell array and casts the Object array to the Cell array
        Cell[] mhosArray = new Cell[cand.length];
        for(int i = 0; i < cand.length; i++) {
            mhosArray[i] = (Cell)(cand[i]);
        }
        mhos = mhosArray;
    }

    /**
     * Calls findMoves for all of the mhos
     */
    private static void findMoves() {
        // calls findMove for all of the mhos
        for (Cell mho : mhos) {
            findMove(mho);
        }
    }

    private static void findMove(Cell mho) {
        // if the mho and the player are in a line, the mho moves towards the player
        if (player.getX() - mho.getX() == 0) {
            verticalMove(mho);
            return;
        } else if (player.getY() - mho.getY() == 0) {
            horizontalMove(mho);
            return;
        }

        // if diagonal move will have to move on a fence or mho, then it returns false and tries to move vertically
        if (!diagonalMove(mho, Cell.Type.FENCE, Cell.Type.MHO)) {
            // if the player is further or equal horizontally, then it tries to move horizontally
            if (player.getX() - mho.getX() >= player.getY() - mho.getY()) {
                if (horizontalMove(mho, Cell.Type.FENCE, Cell.Type.MHO)) {
                    return;
                }
            // if the player is further vertically, then it tries to move vertically
            } else {
                if (verticalMove(mho, Cell.Type.FENCE, Cell.Type.MHO)) {
                    return;
                }
            }
        // if diagonal move did work, then it returns
        } else {
            return;
        }

        // if diagonal move will have to move on a fence or mho, then it returns false and tries to move the other way
        if (!diagonalMove(mho, Cell.Type.MHO)) {
            if (player.getX() - mho.getX() >= player.getY() - mho.getY()) {
                // if the player is further or equal horizontally, then it tries to move horizontally
                horizontalMove(mho, Cell.Type.MHO);
            } else {
                // if the player is further vertically, then it tries to move vertically
                verticalMove(mho, Cell.Type.MHO);
            }
        }
        // if diagonal move did work, then it will just move diagonal
    }

    /**
     * Moves the mho towards the player horizontally
     * If there is an object it should be avoiding and it has to move onto it, it returns false and doesn't move
     *
     * @param mho the mho to be moved
     * @param types the types of cells it should avoid moving onto
     * @return whether it successfully moved or not
     */
    private static boolean horizontalMove(Cell mho, Cell.Type ... types) {
        // change in x direction to move towards the player
        int changeX;

        if (player.getX() < mho.getX()) {
            // if the player is on the left
            changeX = -1;
        } else {
            // if the player is on the right
            changeX = 1;
        }

        // if one of the types is in the way, it returns false
        for (Cell.Type type : types) {
            if (board.grid[mho.getX() + changeX][mho.getY()].getType().equals(type)) {
                return false;
            }
        }

        // moves the mho towards the player and returns true
        move(mho, changeX, 0);

        return true;
    }

    /**
     * Moves the mho towards the player vertically
     * If there is an object it should be avoiding and it has to move onto it, it returns false and doesn't move
     *
     * @param mho the mho to be moved
     * @param types the types of cells it should avoid moving onto
     * @return whether it successfully moved or not
     */
    private static boolean verticalMove(Cell mho, Cell.Type ... types) {
        // change in x direction to move towards the player
        int changeY;

        if (player.getY() < mho.getY()) {
            // if the player is on the above
            changeY = -1;
        } else {
            // if the player is on the right
            changeY = 1;
        }

        // if one of the types is in the way, it returns false
        for (Cell.Type type : types) {
            if (board.grid[mho.getX()][mho.getY() + changeY].getType().equals(type)) {
                return false;
            }
        }

        // moves the mho towards the player and returns true
        move(mho, 0, changeY);

        return true;
    }

    /**
     * Moves the mho towards the player diagonally
     * If there is an object it should be avoiding and it has to move onto it, it returns false and doesn't move
     *
     * @param mho the mho to be moved
     * @param types the types of cells it should avoid moving onto
     * @return whether it successfully moved or not
     */
    private static boolean diagonalMove(Cell mho, Cell.Type... types) {
        // change in x direction to move towards the player
        int changeX;
        // change in y direction to move towards the player
        int changeY;

        if (player.getX() < mho.getX()) {
            // if the player is on the left
            changeX = -1;
        } else {
            // if the player is on the right
            changeX = 1;
        }

        if (player.getY() < mho.getY()) {
            // if the player is above
            changeY = -1;
        } else {
            // if the player below
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

    /**
     * Moves the mho by setting the cell it is moving to as true, and the other as false
     * @param mho the mho that is moving
     * @param changeX the change in X
     * @param changeY the change in Y
     */
    private static void move(Cell mho, int changeX, int changeY) {
        //checks the square the mho is moving to
        if (board.grid[mho.getX() + changeX][ mho.getY() + changeY].getType() == Cell.Type.NOTHING) {
            // if the tile the mho is moving to is empty, then it moves
            board.grid[mho.getX() + changeX][mho.getY() + changeY].setType(Cell.Type.MHO);
        } else if (board.grid[mho.getX() + changeX][ mho.getY() + changeY].getType() == Cell.Type.FENCE) {
            // if the tile the mho is moving to has a fence, then it dies
        } else if (board.grid[mho.getX() + changeX][ mho.getY() + changeY].getType() == Cell.Type.PLAYER) {
            // if the tile the mho is moving to has a player, then the player dies and the mho doesn't
            Main.game.playerLoss();
            return;
        }

        //sets the mhos original place in the board to be equal to nothing
        board.grid[mho.getX()][mho.getY()].setType(Cell.Type.NOTHING);
    }
}
