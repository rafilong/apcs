/**
 * MathSet
 * Code written by Rafi Long
 * See method documentation for specific information
 *
 * A one directional edge object for the graph
 */
public class Edge {
    /** The node that the edge leads from */
    private Node from;

    /** The node the edge leads to */
    private Node to;

    /** The weight of the node */
    private int weight;

    /**
     * Default empty constructor for edge
     * @param to the node to be connected to
     */
    public Edge(Node from, Node to, int weight) {
        this.from = from;
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
     * Default getter for from
     * @return the node from
     */
    public Node getFrom() {
        return from;
    }

    /**
     * Default setter for from
     * @param from the node from
     */
    public void setFrom(Node from) {
        this.from = from;
    }

    /**
     * Default getter for weight
     * @return the weight of the edge
     */
    public int getWeight() {
        return weight;
    }

    /**
     * A toString for edge
     * @return prints the edges information
     */
    public String toString() {
        return from.getName() + " to  " + to.getName() + " with weight " + weight;
    }
}