/**
 * Tests and uses BST
 */
public class Main {
    /**
     * Main is currently testing average tree depth - printing the tree depth for 50 cases with 10000 elements
     * @param args unused parameter
     */
    public static void main(String args[]) {
        int upTo = 999;
        int numTests = 10000;
        double sumDepths = 0;

        for (int j = 0; j < numTests; j++) {
            Randp rands = new Randp(upTo);
            BST<Integer> tree = new BST<Integer>(rands.nextInt());

            for (int i = 0; i < upTo - 1; i++) {
                tree.getTree().insert(rands.nextInt());
            }

            int depth = tree.getTree().depth();
            sumDepths += depth;
            System.out.println(depth);
        }

        System.out.println();
        System.out.println();

        System.out.println("Average depth is:");
        System.out.println(sumDepths / (double) numTests);
    }

}
