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
    /* TESTING */

    /**
     * Main is currently testing average tree depth - printing the tree depth for 50 cases with 10000 elements
     * @param args unused parameter
     */
    public static void main(String args[]) {
        for (int j = 0; j < 50; j++) {
            int testing = 10000;
            Randp rands = new Randp(testing);
            BST<Integer> tree = new BST<Integer>(rands.nextInt());

            for (int i = 0; i < testing - 1; i++) {
                tree.root.insert(rands.nextInt());
            }

            System.out.print(tree.root.depth() + " ");
        }
    }

    /**
     * Generates random arrays for testing purposes only
     * Code given to me by Tyler
     *
     * @param length the length of the array to be created
     * @return an array of random ints
     */
    public static ArrayList<Integer> randArray(int length) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            nums.add(random.nextInt(length * 2));
        }
        return nums;
    }


    /* CODE */

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
