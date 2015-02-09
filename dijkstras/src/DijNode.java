/**
 * A specific node object that stores information relevant to Dijkstras algorithm
 */
public class DijNode extends Node {

    private int shortDist = Integer.MAX_VALUE;

    private DijNode closestFrom = null;

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
