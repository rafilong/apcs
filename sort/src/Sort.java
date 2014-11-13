import java.util.Arrays;

/*
 * ThreeSort homework
 * 9/16/14
 * Code written by by Rafi Long
 *
 * Assignment:
 * Write three methods, one for each
 * Sort using: Bubblesort, insertion sort, selection sort.
 * Result: The returned result is sorted.
 *
 * Resources:
 * http://en.wikipedia.org/wiki/Bubble_sort
 * http://en.wikipedia.org/wiki/Insertion_sort
 * http://en.wikipedia.org/wiki/Selection_sort
 */
public class Sort {
    /**
     * Invokes bubble, insertion, and selection sort and prints the result
     * @param args
     */
    public static void main(String args[]) {
        // the array to be sorted
        int[] array = {5, 7, 2, 3, 1, 8, 6, 4, 9};
        System.out.println("Sorting " + Arrays.toString(array));

        // printed the results of the sorting
        System.out.println("Bubble sort result is " + Arrays.toString(bubbleSort(array)));
        System.out.println("Insertion sort result is " + Arrays.toString(insertionSort(array)));
        System.out.println("Selection sort result is " + Arrays.toString(selectionSort(array)));
    }

    /**
     * Sorts using bubble sort algorithm
     *
     * @param nums the array to be sorted
     * @return a new sorted array
     */
    public static int[] bubbleSort(int[] nums) {
        // a new array to be sorted (arrays are mutable)
        int[] sort = nums.clone();

        // excludes the top value every pass
        for (int unsorted = sort.length; unsorted > 0; unsorted--) {
            // iterates through the unsorted part of the array
            for (int i = 0; i < unsorted -1; i++) {
                // for each value and then next one, it swaps if the first is larger
                if (sort[i] > sort[i+1]) {
                    // swapping values of sort[i] and sort[i+1]
                    int tempVal = sort[i];
                    sort[i] = sort[i+1];
                    sort[i+1] = tempVal;
                }
            }
        }

        // the sorted array
        return sort;
    }

    /**
     * Sorts using insertion sort algorithm
     * Thank you to the Wikipedia pseudo code
     *
     * @param nums the array to be sorted
     * @return a new sorted array
     */
    public static int[] insertionSort(int[] nums) {
        // a new array to be sorted (arrays are mutable)
        int[] sort = nums.clone();

        // iterates for length of the array starting at 1
        for (int i = 1; i < sort.length; i++) {
            // iterates from the current value of i down to 0
            int j = i;
            // continues while j greater than 0 and the next value is smaller than the current one
            while (j > 0 && sort[j-1] > sort[j]) {
                // swapping values in nums[j] and nums[j-1]
                int temp = sort[j];
                sort[j] = sort[j-1];
                sort[j-1] = temp;

                j--;
            }
        }

        // the sorted array
        return sort;
    }

    /**
     * Sorts using selection sort algorithm
     *
     * @param nums the array to be sorted
     * @return a new sorted array
     */
    public static int[] selectionSort(int[] nums) {
        // a new array to be sorted (arrays are mutable)
        int[] sort = nums.clone();

        // makes passes for the length of the array
        for (int pass = 0; pass < sort.length; pass++) {

            // the current lowest number index is set to the pass number
            int lowestNumI = pass;

            // iterates from the pass number to the end of the array
             // (this is because for each pass the lowest number will be sorted)
            for (int i = pass + 1; i < sort.length; i++) {
                // finds the lowest number index
                if (sort[lowestNumI] > sort[i]) {
                    lowestNumI = i;
                }
            }

            // moves the lowest number to the bottom of the part of the array that was just searched
            int lowestNum = sort[lowestNumI];
            sort[lowestNumI] = sort[pass];
            sort[pass] = lowestNum;
        }

        // the sorted array
        return sort;
    }
}
