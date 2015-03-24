import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Binary Search Tree Root
 * Code written by Rafi Long
 *
 * See code for specific documentation
 * Assignment fulfilling http://paleyontology.com/AP_CS/BST.html requirements
 *
 * This class has a field that is a BSTnode, which is the root of the tree
 * Most methods in this class call BSTnode methods
 */
public class BST<T extends Comparable<T>> {
    /** The root of the tree */
    private BSTnode<T> root;

    /**
     * Unused constructor
     */
    public BST(T datum) {
        root = new BSTnode<T>(datum);
    }

    /**
     * Returns the root, from which the whole tree can be accessed
     * @return the root
     */
    public BSTnode<T> getTree() {
        return root;
    }

    /**
     * Returns whether the root is a leaf
     * @return whether the root is a leaf
     */
    public boolean isLeaf() {
        return root.isLeaf();
    }

    /**
     * Calls printTree in BSTnode on the root, which prints the whole tree
     */
    public void printTree() {
        root.printTree();
    }

    /**
     * Calls toString on root
     * @return the root's datum
     */
    public String toString() {
        return root.toString();
    }
}
