/**
 *
 */
public class Hamiltonian {
    private static TSP solver;

    public static boolean hasPath(int[] myPoint) {
        return solver.hasPath();
    }

    public static int[][] getPath(int[] myPoint) {
        return solver.getPath();
    }
}
