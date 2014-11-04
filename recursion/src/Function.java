/**
 * Solution to exercise 1.11 in:
 * http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_sec_1.2
 *
 * Objective:
 * A function f is defined by the rule that f(n) = n if n<3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n>3.
 * Write a procedure that computes f by means of a recursive process. Write a procedure that computes f by means
 * of an iterative process.
 *
 * Problems with the question:
 * The question does not define what happens when n=3. This means I'm interpreting the question as though
 * f(n) = n when n<=3, and n never equals 0;
 *
 * @author Rafi Long
 */
public class Function {

    /**
     * Tests recursiveFunction() and iterativeFunction()
     * @param args unused parameter
     */
    public static void main(String args[]) {
        System.out.println("Expected value is 1657");
        System.out.println(recursiveFunction(10));
        System.out.println(iterativeFunction(10));
    }

    /**
     * A recursive version of:
     * f(n) = n if n<=3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n>3
     * @param n the value of n that is to be found
     * @return f(n)
     */
    public static int recursiveFunction(int n) {
        if (n <= 3) {
            return n;
        } else {
            return recursiveFunction(n - 1) + 2*recursiveFunction(n - 2) + 3*recursiveFunction(n - 3);
        }
    }

    /**
     * An iterative version of:
     * f(n) = n if n<=3 and f(n) = f(n - 1) + 2f(n - 2) + 3f(n - 3) if n>3
     * @param n the value of n that is to be found
     * @return f(n)
     */
    public static int iterativeFunction(int n) {
        // when n <= 3
        if (n <= 3) {
            return n;
        }

        // the values of f(n-1), f(n-2), and f(n-3)
        int firstValue = 1;
        int secondValue = 2;
        int thirdValue = 3;

        // placeholder so values aren't overwritten
        int fourthValue = 0;
        for (int i = 4; i <= n; i++) {
            // finding the new value
            fourthValue = thirdValue + 2*secondValue + 3*firstValue;

            // moving the old values up
            firstValue = secondValue;
            secondValue = thirdValue;
            thirdValue = fourthValue;
        }

        // returns the ultimate value
        return thirdValue;
    }
}
