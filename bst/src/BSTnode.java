import java.util.ArrayList;

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

    public BSTnode<T> getLeft() {
        return left;
    }

    public BSTnode<T> getRight() {
        return right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void insert(T datum) {
        if (datum.compareTo(this.datum) < 0) {
            if (left.datum == null) {
                setLeft(datum);
            } else {
                left.insert(datum);
            }
        } else {
            if (right.datum == null) {
                setRight(datum);
            } else {
                right.insert(datum);
            }
        }
    }

    public void setLeft(T datum) {
        left = new BSTnode<T>(datum);
    }

    public void setRight(T datum) {
        right = new BSTnode<T>(datum);
    }

    public void printTree() {
        ArrayList<BSTnode<T>> levelNodes = new ArrayList<BSTnode<T>>();
        ArrayList<BSTnode<T>> nxtLevelNodes = new ArrayList<BSTnode<T>>();
        levelNodes.add(this);

        for (int i = 0; i < depth(); i++) {
            for (BSTnode<T> node : levelNodes) {
                System.out.print(node + " ");
                nxtLevelNodes.add(node.getLeft());
                nxtLevelNodes.add(node.getRight());
            }
            System.out.println();
            levelNodes.clear();
            levelNodes.addAll(nxtLevelNodes);
            nxtLevelNodes.clear();
        }
    }

    public int depth() {
        if (this.isLeaf()) return 1;
        return Math.max(left.depth(), right.depth()) + 1;
    }

    public String toString() {
        return datum.toString();
    }
}
