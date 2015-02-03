/**
 * A node object for a graph that supports the add method
 */
public class Node {
    /** The edge in the graph */
    private Edge connect = null;

    /**
     * The default constructor for node
     */
    public Node() {
    }

    /**
     * The default constructor for node
     * @param connect the edge to connect to
     */
    public Node(Edge connect) {
        this.connect = connect;
    }

    /**
     * The default getter for connect
     * @return the edge connect
     */
    public Edge getConnect() {
        return connect;
    }

    /**
     * The default setter for connect
     * @param connect the edge connect
     */
    public void setConnect(Edge connect) {
        this.connect = connect;
    }
}