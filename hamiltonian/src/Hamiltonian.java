/**
 * A class that returns information about Hamiltonian paths in a set of points
 *
 * Implementation:
 * This class uses the TSP class in order to calculate the path, as a solution of the traveling salesman problem
 * is also a Hamiltonian path. When hasPath and getPath are called, a new TSP object is created and the return
 * of that call is directly returned through Hamiltonian. This class also implements PathFinder, as it finds paths.
 */
public class Hamiltonian implements PathFinder {

    /**
     * An empty constructor
     */
    public Hamiltonian(){}

    /**
     * Checks whether or not there is a Hamiltonian path in the set of points.
     * Directly returns TSP's hasPath function output.
     *
     * @param points the points for which a Hamiltonian path is to be checked
     * @return whether or not there is a path
     */
    public boolean hasPath(MyPoint[] points) {
        return new TSP().hasPath(points);
    }

    /**
     * Returns a Hamiltonian path if there is one
     * Directly returns TSP's getPath function output.
     *
     * The return is a table in which the first column has the listed points, and the second column with the same row
     * contains the next point in the path.
     *
     * @param points the points for which a Hamiltonian path is to be found
     * @return the path
     */
    public MyPoint[][] getPath(MyPoint[] points) {
        return new TSP().getPath(points);
    }
}
