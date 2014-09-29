/*
 * AP Computer Science Flag Project
 * Code written by Rafi Long
 * See code for documentation
 */

/**
 * Contains all of the different types of cell
 * Allows the type to be changed
 * @author Rafi Long
 */
public class Cell {
    /**
     * The different types of objects that can fill the cells
     */
    public enum Type {
        NOTHING, MHO, FENCE, PLAYER;
    }

    /** The type of the cell (can change) */
    private Type type = Type.NOTHING;
    /** The x coordinate of the cell (doesn't change) */
    private int x = 0;
    /** The y coordinate of the clel (doesn't change) */
    private int y = 0;

    /**
     * Constructor for cell
     * @param type the type of the cell
     * @param x the x coordinate of the cell
     * @param y the y coordinate of the cell
     */
    public Cell(Type type, int x, int y) {
        this.type = type;

    }

    /**
     * Returns the type
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the type
     * @param type the type of the cell
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Returns the x
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y
     * @return the y
     */
    public int getY() {
        return y;
    }
}
