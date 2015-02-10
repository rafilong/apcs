import java.util.Collections;
import java.util.UUID;

/**
 * A specific node object that stores information relevant to Dijkstras algorithm
 */
public class DijNode extends Node {
    /** The shortest distance from the start node to this one */
    private int shortDist = Integer.MAX_VALUE;

    /** The node the shortest path will pass through immediately */
    private DijNode closestFrom = null;

    /**
     * A constructor for node
     * Randomly generates the name of the node
     */
    public DijNode() {
        this.name = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    /**
     * A constructor for node
     * @param name the name of the node
     */
    public DijNode(String name) {
        this.name = name;
    }

    /**
     * A constructor for node
     * @param edges the edge to connect to
     */
    public DijNode(Edge[] edges) {
        Collections.addAll(this.edges, edges);
    }

    /**
     * Gets current shortest found distance
     * @return the current shortest found distance
     */
    public int getShortDist() {
        return shortDist;
    }

    /**
     * A setter for the shortest found distance
     * @param shortDist the new shortest distance
     */
    public void setShortDist(int shortDist) {
        this.shortDist = shortDist;
    }

    /**
     * Returns the closest node on the shortest path
     * @return the closest node on the shortest path
     */
    public DijNode getClosestFrom() {
        return closestFrom;
    }

    /**
     * Sets a new node to be the closest node on the shortest path
     * @param closestFrom the new closest node
     */
    public void setClosestFrom(DijNode closestFrom) {
        this.closestFrom = closestFrom;
    }
}
