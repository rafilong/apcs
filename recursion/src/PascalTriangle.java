/**
 * Solution to exercise 1.11 in:
 * http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_sec_1.2
 *
 * Objective:
 * Write a procedure that computes elements of Pascal's triangle by means of a recursive process.
 *
 * @author Rafi Long
 */
public class PascalTriangle {

    /**
     * Tests findValue()
     * @param args unused parameter
     */
    public static void main(String args[]) {
        // prints the first 10 rows of Pascal's Triangle
        for (int row = 0; row < 10; row ++) {
            for (int dFromLeft = 0; dFromLeft <= row; dFromLeft++) {
                System.out.print(findValue(row, dFromLeft) + " ");
            }
            System.out.println();
        }
    }

    /**
     * Finds the value of
     * @param row the row, where row=0 is the first row
     * @param dFromLeft the distance from the leftmost value
     * @return the value of the variable at the given position
     */
    public static int findValue(int row, int dFromLeft) {
        // returns 1 for the left edge
        if (dFromLeft == 0) {
            return 1;
        // returns 1 for the right edge
        } else if (dFromLeft == row) {
            return 1;
        // returns the added values of the number above and to the left, and above and to the right
        } else {
            return findValue(row-1, dFromLeft - 1) + findValue(row-1, dFromLeft);
        }
    }
}
