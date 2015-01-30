/**
 * A node object for a graph that supports the add method
 */
public class Node {
    /** The edge in the graph */
    private Edge connect = null;

    /** The data in the node */
    private Object datum;

    /**
     * The default constructor for node
     * @param datum the data to be inserted
     */
    public Node(Object datum) {
        this.datum = datum;
    }

    /**
     * Adds the datum to the bottom of the tree
     * @param datum the datum to be added
     */
    public void add(Object datum) {
        if (connect != null) {
            connect.getTo().add(datum);
        } else {
            connect = new Edge(new Node(datum));
        }
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

    /**
     * The default getter for datum
     * @return the object datum
     */
    public Object getDatum() {
        return datum;
    }

    /**
     * The default setter for datum
     * @param datum the object to be set as datum
     */
    public void setDatum(Object datum) {
        this.datum = datum;
    }
}
