import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Median Finder
 * Code written by Rafi Long
 * Used information from http://www.cs.rit.edu/~zjb/courses/800/lec4.pdf
 *
 * Tyler helped with showing me scenarios that the program might have difficulty with
 */
public class FindMedian {

    public static void main(String args[]) {
        testLots();
    }

    public static void testOne(int[] nums) {
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Find median: " + findMedian(nums, 0, 0));
    }

    public static void testLots() {
        int wrong = 0;

        for (int i = 0; i < 1000000; i++) {
            int[] nums = randArray(31);
            System.out.println(Arrays.toString(nums));

            if (findMedian(nums, 0, 0) != bruteMedian(nums)) {
                System.out.println(Arrays.toString(nums));
                System.out.println("Find median: " + findMedian(nums, 0, 0));
                System.out.println("Brute median: " + bruteMedian(nums));
                wrong++;
            }
        }

        System.out.println(wrong + " cases wrong");
    }

    /**
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
     *
     * @param nums the values
     * @return the median
     */
    public static int findMedian(int[] nums, int numsBelow, int numsAbove) {
        int pivot = findPivot(nums);
        ArrayList<Integer> less = new ArrayList<Integer>();
        ArrayList<Integer> same = new ArrayList<Integer>();
        ArrayList<Integer> larger = new ArrayList<Integer>();

        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                larger.add(num);
            } else {
                same.add(num);
            }
        }

        if (same.size() >= less.size() + numsBelow && same.size() >= larger.size() + numsAbove) {
            return pivot;
        } else if (Math.abs((less.size() + numsBelow) - (larger.size() + numsAbove)) <= same.size()) {
            return pivot;
        } else if (less.size() + numsBelow > larger.size() + numsAbove) {
            return findMedian(objectToInt(less.toArray()), numsBelow, numsAbove + larger.size() + same.size());
        } else if (larger.size() + numsAbove > less.size() + numsBelow) {
            return findMedian(objectToInt(larger.toArray()), numsBelow + less.size() + same.size(), numsAbove);
        } else {
            return pivot;
        }
    }

    /**
     * Converts an array of objects to an array of ints
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
     * Code adopted from Tyler's code
     *
     * @param nums the numbers to be sorted
     * @return the median
     */
    public static int bruteMedian(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length /2];
    }
}
