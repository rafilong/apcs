import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

/**
 * MathSet
 * Code written by Rafi Long
 * See method documentation for specific information
 *
 * A node object for a graph that supports the add method
 */
public class Node {
    /** The edge in the graph */
    protected ArrayList<Edge> edges = new ArrayList<Edge>();

    /** A name for debugging purposes */
    protected String name;

    /**
     * A constructor for node
     * Randomly generates the name of the node
     */
    public Node() {
        name = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    /**
     * A constructor for node
     * @param name the name of the node
     */
    public Node(String name) {
        this.name = name;
    }

    /**
     * A constructor for node
     * @param edges the edge to connect to
     */
    public Node(Edge[] edges) {
        Collections.addAll(this.edges, edges);
    }

    /**
     * The default getter for edge
     * @return the edge that connects
     */
    public Edge[] getEdges() {
        Edge[] aEdges = new Edge[edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            aEdges[i] = edges.get(i);
        }
        return aEdges;
    }

    /**
     * Adds an already created edge
     * @param edge the edge to add to connect
     */
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    /**
     * Creates an edge and adds it
     * @param to the node to connect to
     * @param weight the weight of the edge
     */
    public void addEdge(Node to, int weight) {
        edges.add(new Edge(this, to, weight));
    }

    /**
     * Returns the name of the node
     * @return the name of the node
     */
    public String getName() {
        return name;
    }
}