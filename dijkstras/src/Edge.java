/**
 * A edge object for a graph
 */
public class Edge {
    /** The node the edge leads to */
    private Node to;

    /** The weight of the node */
    private int weight;

    /**
     * Default empty constructor for edge
     * @param to the node to be connected to
     */
    public Edge(Node to, int weight) {
        this.to = to;
        this.weight = weight;
    }


    public Edge(int weight) {
        this.weight = weight;
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

    /**
     * Default getter for weight
     * @return the weight of the edge
     */
    public int getWeight() {
        return weight;
    }
}