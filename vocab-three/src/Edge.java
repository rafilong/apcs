/**
 * A edge object for a graph
 */
public class Edge {
    /** The node the edge leads to */
    private Node to;

    /**
     * Default empty constructor for edge
     * @param to the node to be connected to
     */
    public Edge(Node to) {
        this.to = to;
    }

    /**
     * Default getter for to
     * @return the node to
     */
    public Node getTo() {
        return to;
    }

    /**
     * Default setter for to
     * @param to the node to
     */
    public void setTo(Node to) {
        this.to = to;
    }
}
