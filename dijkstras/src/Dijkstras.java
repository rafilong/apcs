import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class Dijkstras {

    private Graph graph;

    private ArrayList<Node> unselected;

    public Dijkstras(Graph graph) {
        this.graph = graph;
        unselected = new ArrayList<Node>(Arrays.asList(graph.getNodes()));
    }

    public Dijkstras(int[][] matrix) {
        for (int[] node : matrix) {
            graph.addNode(new DijNode());
        }

        for (int n = 0; n < matrix.length; n++) {
            for (int e = 0; e < matrix.length; e++) {
                if (matrix[n][e] != -1) {
                    graph.getNodes()[n].addEdge(graph.getNodes()[e], matrix[n][e]);
                }
            }
        }
    }
}
