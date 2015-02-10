import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that uses the Node and Edge class to create a graph
 */
public class DijGraph {
    /** The start of the graph */
    private DijNode start;

    /** The nodes in the graph */
    private ArrayList<DijNode> nodes = new ArrayList<DijNode>();

    /**
     * An empty constructor for DijGraph
     */
    public DijGraph() {}

    /**
     * A constructor for DijGraph with all of the nodes
     * @param start the node to start from
     * @param nodes all of the nodes in the graph
     */
    public DijGraph(DijNode start, DijNode[] nodes) {
        this.start = start;
        Collections.addAll(this.nodes, nodes);
    }

    /**
     * A constructor for DijGraph with the start node
     * @param start the node to start from
     */
    public DijGraph(DijNode start) {
        this.start = start;
    }

    /**
     * A constructor for DijGraph that uses a matrix
     * @param matrix an adjacency matrix
     */
    public DijGraph(int[][] matrix) {
        for (int[] node : matrix) {
            nodes.add(new DijNode());
        }

        for (int n = 0; n < matrix.length; n++) {
            for (int e = 0; e < matrix.length; e++) {
                if (matrix[n][e] != -1) {
                    nodes.get(n).addEdge(nodes.get(e), matrix[n][e]);
                }
            }
        }
    }

    /**
     * Returns the nodes
     * @return the nodes in an array
     */
    public DijNode[] getNodes() {
        DijNode[] aNodes = new DijNode[nodes.size()];

        for (int i = 0; i < nodes.size(); i++) {
            aNodes[i] = nodes.get(i);
        }

        return aNodes;
    }

    /**
     * Adds a node to the ArrayList of nodes
     * @param node the node to be added
     */
    public void addNode(DijNode node) {
        nodes.add(node);
    }

    /**
     * Sets the starting node for the graph
     * @param start the starting node
     */
    public void setStart(DijNode start) {
        this.start = start;
    }

    /**
     * Adds a link between two nodes
     * @param from the node the edge comes from
     * @param to the node the edge goes to
     * @param weight the weight of the edge
     */
    public void addLink(Node from, Node to, int weight) {
        from.addEdge(new Edge(from, to, weight));
    }

    /**
     * Prints all of the edges of the graph in a readable manner
     */
    public void printGraph() {
        for (Node node : nodes) {
            for (Edge edge : node.getEdges()) {
                System.out.println(edge);
            }
        }
    }

    /**
     * Returns the start node of the graph
     * @return the start node of the graph
     */
    public Node getStartNode() {
        return start;
    }
}
