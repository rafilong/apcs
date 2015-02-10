/**
 * Created to test Dijkstras.java
 */
public class Main {

    /**
     * Tests Dijkstras with the graph found in the random presentation on Schoology
     * @param args unused parameter
     */
    public static void main(String args[]) {
        // a variable to let me avoid typing -1 48 times
        int n = -1;

        // creating a new object through entering a matrix
        // -1 signifies no connection
        Dijkstras test = new Dijkstras(new int[][]{
                {n, 8, n, n, n, 10, n, n}, //2  A  2
                {n, n, 4, n, 10, n, n, n}, //4  B  2
                {n, n, n, 3, n, n, n, n},  //5  C  1
                {n, n, n, n, 25, 18, n, n},//7  D  2
                {n, n, n, 9, n, n, 7, n},  //9  E  2
                {5, 7, 3, n, 2, n, n, n},  //12 F  3
                {n, n, n, 2, n, n, n, 3},  //14 G  2
                {4, 9, n, n, n, n, n, n}}  //16 H  2
        , new String[]{"a", "b", "c", "d", "e", "f", "g", "h"});

        // the shortest paths are automatically

        // prints the result of the graph
        test.printResult();
    }
}
