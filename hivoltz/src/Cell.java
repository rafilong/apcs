/**
 * @author Rafi Long
 */
public class Cell {
    public enum Type {
        NOTHING, MHO, FENCE, PLAYER;
    }

    public Type type = Type.NOTHING;

    public Cell(Type type, int x, int y) {
        this.type = type;

    }
}
