import java.util.Collections;
import java.util.UUID;

/**
 * A specific node object that stores information relevant to Dijkstras algorithm
 */
public class DijNode extends Node {

    private int shortDist = Integer.MAX_VALUE;

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


    public int getShortDist() {
        return shortDist;
    }

    public void setShortDist(int shortDist) {
        this.shortDist = shortDist;
    }

    public DijNode getClosestFrom() {
        return closestFrom;
    }

    public void setClosestFrom(DijNode closestFrom) {
        this.closestFrom = closestFrom;
    }
}
