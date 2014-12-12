/**
 *
 */
public class BSTnode<T extends Comparable> {

    private T datum;

    private BSTnode<T> left;

    private BSTnode<T> right;

    public BSTnode(T datum) {
        this.datum = datum;
        this.left = null;
        this.right = null;
    }

    public T getDatum() {
        return datum;
    }

    public BSTnode getLeft() {
        return left;
    }

    public BSTnode<T> getRight() {
        return right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void insert(T datum) {

    }

    public void setLeft(T datum) {
        left = new BSTnode<T>(datum);
    }

    public void setRight(T datum) {
        right = new BSTnode<T>(datum);
    }

    public void delete(T datum) {

    }

    public void printTree() {

    }

    public int depth() {
        if (this.isLeaf()) return 1;
        return Math.max(left.depth(), right.depth()) + 1;
    }

    public String toString() {
        return datum.toString();
    }
}
