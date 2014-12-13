import java.util.ArrayList;

/**
 * 
 */
public class Randp {

    /** TEST **/

    /**
     * Calls the randp test method
     * @param args
     */
    public static void main(String args[]) {
        test();
    }

    /**
     * Tests all Randp code
     *
     * Expected outcome:
     * - prints 16 numbers, each on a new line
     *  - the first 10 numbers are 1-10 in random order
     *  - the next 6 numbers are 0
     */
    public static void test() {
        // creates a new Randp object of size 10
        Randp rands = new Randp(10);

        // calls nextInt 16 times and prints the output
        for (int i = 0; i < 16; i++) {
            System.out.println(rands.nextInt());
        }
    }


    /** CODE **/

    /** A list of random numbers, with no repeats, and up to the argument in the object call */
    private ArrayList<Integer> randNums = new ArrayList<Integer>();

    /**
     * Fills randNums with numbers 1 - length in random order
     * @param length the number up to with randNums should include
     */
    public Randp(int length) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= length; i++) {
            nums.add(i);
        }

        for (int i = 0 ; i < length; i++) {
            int num = nums.remove((int) (Math.random() * nums.size()));
            randNums.add(i, num);
        }
    }

    /**
     * Removes the last element in randNums and returns it
     * This number is a random number between 1 and length
     * Returns 0 if there are no elements left
     *
     * @return the last element in randNums or 0 if there are no elements left
     */
    public int nextInt(){
        if (randNums.size() > 0) {
            return randNums.remove(randNums.size() - 1);
        } else {
            return 0;
        }
    }
}
