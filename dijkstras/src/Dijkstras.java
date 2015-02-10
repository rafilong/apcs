import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class Dijkstras {
    /** The graph where the shortest paths are to be found */
    private Graph graph;

    /** The nodes that are currently not selected as the minimum */
    private ArrayList<DijNode> unselected;

    /** Nodes already selected as the minimum and search */
    private ArrayList<DijNode> selected = new ArrayList<DijNode>();

    /**
     * A constructor for Dijkstra that uses a graph as input
     * Node names are randomly assigned using UUIDs - find the names by calling printGraph in Graph
     * This constructor also calls methods to calculate the shortest paths
     *
     * @param graph the graph of nodes and edges to calculate on
     */
    public Dijkstras(Graph graph) {
        this.graph = graph;
        setStart();
        this.calculate();
    }

    /**
     * A constructor for Dijkstra that uses a matrix as input, and converts it to a graph
     * Node names are randomly assigned using UUIDs - find the names by calling printGraph in Graph
     * This constructor also calls methods to calculate the shortest paths
     *
     * @param matrix
     */
    public Dijkstras(int[][] matrix) {
        // creates the nodes and sets the names
        graph = new Graph();
        for (int[] node : matrix) {
            graph.addNode(new DijNode());
        }
        graph.setStart(graph.getNodes()[6]);

        // sets the edges in between the nodes
        matrixSetEdges(matrix);
        // sets up the start node in order to be able to begin calculations
        setStart();
        // begins calcuations
        this.calculate();
    }

    public Dijkstras(int[][] matrix, String[] names) {
        // creates the nodes and starts setting names
        graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            graph.addNode(new DijNode(names[i]));
        }
        graph.setStart(graph.getNodes()[6]);

        // sets the edges in between the nodes
        matrixSetEdges(matrix);
        // sets up the start node in order to be able to begin calculations
        setStart();
        // begins calcuations
        this.calculate();
    }

    /**
     * Sets the edges between the nodes using an adjacency matrix
     * Meant to only be used upon object creation by matrix
     *
     * @param matrix the adjacency matrix to find the nodes in
     */
    private void matrixSetEdges(int[][] matrix) {
        // for the nodes and edges
        for (int n = 0; n < matrix.length; n++) {
            for (int e = 0; e < matrix.length; e++) {
                // if the weight isn't -1, which means there is no connection
                if (matrix[n][e] != -1) {
                    // adds an edge between the nodes in question
                    graph.getNodes()[n].addEdge(graph.getNodes()[e], matrix[n][e]);
                }
            }
        }
    }

    /**
     * Sets the start of the graph to be actually recognized as the start, and to
     * remove and add it from the correct lists (eg unselected and selected)
     */
    private void setStart() {
        unselected = new ArrayList<DijNode>(Arrays.asList((DijNode[]) graph.getNodes()));
        ((DijNode) graph.getStartNode()).setShortDist(0);
        unselected.remove(graph.getStartNode());
        selected.add((DijNode) graph.getStartNode());
    }

    /**
     * Removes all of the values generated
     * @param graph
     */
    public void reset(Graph graph) {
        for (DijNode node : (DijNode[]) graph.getNodes()) {
            node.setShortDist(Integer.MAX_VALUE);
            node.setClosestFrom(null);
        }

        unselected = new ArrayList<DijNode>(Arrays.asList((DijNode[]) selected.toArray()));
        selected = new ArrayList<DijNode>();
        setStart();
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
                if (to.getShortDist() >= node.getShortDist() + node.getEdges()[e].getWeight()) {
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
        System.out.println("The results of Dijkstra in format Node | Closest node on path | Total distance to node");
        for (DijNode node : (DijNode[]) graph.getNodes()) {
            System.out.print(node.getName() + " ");
            if (node.getClosestFrom() == null) {
                System.out.print("-" + " ");
            } else {
                System.out.print(node.getClosestFrom().getName() + " ");
            }
            System.out.println(node.getShortDist());
        }
    }
}
