import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Median Finder
 * Code written by Rafi Long
 * Used information from http://www.cs.rit.edu/~zjb/courses/800/lec4.pdf
 *   NOTE: the final algorithm is completely different, and the only ideas taken from
 *   this presentation was the idea that when the array is divided into two parts where
 *   one side has values only greater than the others, that the median will be in the side
 *   with the most values.
 *
 * Tyler helped with showing me scenarios that the program might have difficulty with
 */
public class FindMedian {

    /**
     * Standard main method
     * Calls a helper method that tests the program
     *
     * @param args
     */
    public static void main(String args[]) {
        testLots();
    }

    /**
     * Prints the array entered and the median of the array
     * @param nums the array
     */
    public static void testOne(int[] nums) {
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Find median: " + findMedian(nums, 0, 0));
    }

    /**
     * Tests a large number of cases for the correct median
     * Uses a sort algorithm and the middle value to check if the median is correct
     */
    public static void testLots() {
        // the number of cases wrong
        int wrong = 0;
        // the total number of cases to be tested
        int total = 1000000;

        // iterating for the number of cases to be tested
        for (int i = 0; i < total; i++) {
            // generating random arrays
            int[] nums = randArray(55);

            // find the median of the random array by brute force and with the O(n) system
            double find = findMedian(nums, 0, 0);
            double brute = bruteMedian(nums);

            // if the find median isn't correct (brute force is always correct)
            if (find != brute) {
                // printing information to help with error messages if the findMedian() is incorrect
                System.out.println(Arrays.toString(nums));
                System.out.println("Find median: " + find);
                System.out.println("Brute median: " + brute);
                Arrays.sort(nums);
                System.out.println(Arrays.toString(nums));
                System.out.println();

                // increments the number of wrong cases
                wrong++;
            }
        }

        // prints the total number of cases right and wrong
        System.out.println(wrong + " cases wrong, " + (total - wrong) + " cases right");
    }

    /**
     * Generates random arrays for testing purposes only
     * Code given to me by Tyler
     *
     * @param length the length of the array to be created
     * @return an array of random ints
     */
    public static int[] randArray(int length) {
        int[] nums = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt(length * 2);
        }
        return nums;
    }

    /**
     * Finds the median value from the array by using a variation of quicksort
     * Partitions the array into elements below, above, and the same to a pivot
     *   then compares the sizes of these 3, and the number of elements already removed
     *   from both sides, to find the median.
     *
     * The median will always be in the side with the closest to equal elements on either side.
     * This is because the median is in the middle
     *
     * See code for specific documentation
     *
     * @param nums the values
     * @param numsBelow number of values removed from below the target array
     * @param numsAbove number of values removed from above the target array
     * @return the median
     */
    public static double findMedian(int[] nums, int numsBelow, int numsAbove) {
        // the pivot to partition the array into
        int pivot = findPivot(nums);

        // arraylists for each partition
        ArrayList<Integer> less = new ArrayList<Integer>();
        ArrayList<Integer> same = new ArrayList<Integer>();
        ArrayList<Integer> larger = new ArrayList<Integer>();

        // adding elements to the partitions
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                larger.add(num);
            } else {
                same.add(num);
            }
        }

        // if the difference between the two sides of the pivot are less than or equal two the number
        //   of occurrences of the pivot, then the median is the pivot
        if (Math.abs((less.size() + numsBelow) - (larger.size() + numsAbove)) <= same.size()) {
            return pivot;
        // if the numbers of elements below the pivot (including ones removed) are greater than the number of elements
        //   above, then the median is in the still-unremoved elements below the pivot
        } else if (less.size() + numsBelow > larger.size() + numsAbove) {
            return findMedian(objectToInt(less.toArray()), numsBelow, numsAbove + larger.size() + same.size());
        // if the numbers of elements above the pivot (including ones removed) are greater than the number of elements
        //   below, then the median is in the still-unremoved elements above the pivot
        } else if (larger.size() + numsAbove > less.size() + numsBelow) {
            return findMedian(objectToInt(larger.toArray()), numsBelow + less.size() + same.size(), numsAbove);
        // if none of these are true, than the median is the pivot
        //   this is just a clause to make the program simpler, as it is never true
        } else {
            System.out.println("This is never true");
            return pivot;
        }
    }

    /**
     * Converts an array of objects to an array of ints
     *
     * @param nums the array of objects
     * @return the corresponding array of ints
     */
    public static int[] objectToInt(Object[] nums) {
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = (Integer) nums[i];
        }
        return ints;
    }

    /**
     * Returns the value at the middle indice in the array
     *
     * Tried finding the median of the first, last, and middle element in the array as the pivot,
     * but it didn't work. It was suggested by http://paly.io/choosepivot
     *
     * @param nums the list of numbers
     * @return the middle value
     */
    public static int findPivot(int[] nums) {
        return nums[nums.length/2];
    }

    /**
     * Finds the median by sorting the array and returning the middle element
     * Only works for arrays with an odd number of indices
     * Code adopted from Tyler's code
     *
     * @param nums the numbers to be sorted
     * @return the median
     */
    public static double bruteMedian(int[] nums) {
        Arrays.sort(nums);
        if (nums.length % 2 == 1) {
            return nums[nums.length /2];
        } else {
            return ((double) nums[(nums.length - 1) / 2] + (double) nums[(nums.length + 1) / 2]) / 2;
        }
    }
}
