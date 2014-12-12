/**
 *
 */
public class BST<T extends Comparable<T>> {

    private BSTnode<T> root;

    public BST() {

    }

    public BSTnode<T> getTree() {
        return root;
    }

    public boolean isLeaf() {
        return root.isLeaf();
    }

    public void printTree() {

    }

    public String toString() {
        return root.toString() + " value of " + root.getDatum();
    }
}
