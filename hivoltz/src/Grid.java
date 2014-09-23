/**
 *  @author Rafi Long
 */
public class Grid {
    /** A reference to the cell that contains the player */
    public Cell player;
    /** A reference to the cells with mhos */
    public Cell[] mhos = new Cell[12];
    /** All of the objects in the grid */
    public Cell[][] grid = new Cell[12][12];

    /**
     * A constructor that calls all of the initiative methods
     */
    public Grid() {

    }

    /**
     * Creates fences around the edge
     * Randomly spawns the other 12 fences
     */
    public void initFences() {

    }

    /**
     * Randomly spawns the player in a space with no fence
     */
    public void initPlayer() {

    }

    /**
     * Randomly spawns the mhos in spaces that don't have a player or a fence
     */
    public void initMhos() {

    }
}