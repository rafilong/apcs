/**
 * An interface created to allow different pathfinding algorithms support polymorphism, creating easier generalization.
 */
public interface PathFinder {

    /**
     * Whether there is a valid path between the set of points
     * @param points the points in question
     * @return if there is a valid path
     */
    public abstract boolean hasPath(MyPoint[] points);

    /**
     * Returns the path.
     *
     * The return is a table in which the first column has the listed points, and the second column with the same row
     * contains the next point in the path.
     *
     * @param points the points for which a traveling salesman path path is to be found
     * @return the path
     */
    public abstract MyPoint[][] getPath(MyPoint[] points);
}
