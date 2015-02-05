import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that uses the Node and Edge class to create a graph
 */
public class Graph {
    /** The start of the graph */
    private Node start;

    /** The nodes in the graph */
    private ArrayList<Node> nodes;

    /**
     * A constructor for Graph with all of the nodes
     * @param start the node to start from
     * @param nodes all of the nodes in the graph
     */
    public Graph(Node start, Node[] nodes) {
        this.start = start;
        Collections.addAll(this.nodes, nodes);
    }

    /**
     * A constructor for Graph with the start node
     * @param start the node to start from
     */
    public Graph(Node start) {
        this.start = start;
    }

    /**
     * A constructor for Graph that uses a matrix
     * @param matrix an adjacency matrix
     */
    public Graph(int[][] matrix) {
        
    }

    /**
     * Returns the nodes
     * @return the nodes in an array
     */
    public Node[] getNodes() {
        return (Node[]) nodes.toArray();
    }

    /**
     * Adds a node to the ArrayList of nodes
     * @param node the node to be added
     */
    public void addNode(Node node) {
        nodes.add(node);
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
}
