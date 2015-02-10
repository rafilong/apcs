import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class Dijkstras {

    private Graph graph;

    private ArrayList<DijNode> unselected;

    private ArrayList<DijNode> selected = new ArrayList<DijNode>();

    public Dijkstras(Graph graph) {
        this.graph = graph;

        unselected = new ArrayList<DijNode>(Arrays.asList((DijNode[]) graph.getNodes()));
        unselected.remove(graph.getStartNode());
        selected.add((DijNode) graph.getStartNode());
    }

    public Dijkstras(int[][] matrix) {
        String[] abc = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        graph = new Graph(new Node(abc[0]));
        for (int i = 1; i < matrix.length; i++) {
            graph.addNode(new Node(abc[i]));
        }

        for (int n = 0; n < matrix.length; n++) {
            for (int e = 0; e < matrix.length; e++) {
                if (matrix[n][e] != -1) {
                    graph.getNodes()[n].addEdge(graph.getNodes()[e], matrix[n][e]); // check this
                }
            }
        }

        unselected = new ArrayList<DijNode>(Arrays.asList((DijNode[]) graph.getNodes()));
        unselected.remove(graph.getStartNode());
        selected.add((DijNode) graph.getStartNode());
    }

    public void reset() {

    }

    public void calculate() {
        while (unselected.size() > 0) {
            updateUnselected();
            selectMin();
        }
    }

    public void updateUnselected() {
        for (DijNode node : selected) {
            for (int e = 0; e < node.getEdges().length; e++) {
                DijNode to = (DijNode) node.getEdges()[e].getTo();
                if (to.getShortDist() > node.getShortDist() + node.getEdges()[e].getWeight()) {
                    to.setClosestFrom(node);
                    to.setShortDist(node.getShortDist() + node.getEdges()[e].getWeight());
                }
            }
        }
    }

    public void selectMin() {
        DijNode minNode = unselected.get(0);

        for (DijNode node : unselected) {
            if (node.getShortDist() < minNode.getShortDist()) {
                minNode = node;
            }
        }

        unselected.remove(minNode);
        selected.add(minNode);
    }

    public void printResult() {
        for (DijNode node : selected) {
            System.out.println(node.getName() + " " + node.getClosestFrom());
        }
    }
}
