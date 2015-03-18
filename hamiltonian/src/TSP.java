/**
 * A class that returns information about traveling salesman solutions in a set of points
 *
 * Implementation:
 * This class is currently full of empty functions, as it serves as an example of how Hamiltonian and TSP will
 * interact. Because of this running the code will generate compile errors unless code is added.
 */
public class TSP implements PathFinder {

    /**
     * An empty constructor
     */
    public TSP() {}

    /**
     * Checks whether or not there is a traveling salesman solution in the set of points.
     *
     * @param points the points for which a Hamiltonian path is to be checked
     * @return whether or not there is a path
     */
    @Override
    public boolean hasPath(MyPoint[] points) {
        // TSP implementation goes here
    }

    /**
     * Returns a traveling salesman path if there is one
     *
     * The return is a table in which the first column has the listed points, and the second column with the same row
     * contains the next point in the path.
     *
     * @param points the points for which a traveling salesman path path is to be found
     * @return the path
     */
    @Override
    public MyPoint[][] getPath(MyPoint[] points) {
        // TSP implementation goes here
    }
}
