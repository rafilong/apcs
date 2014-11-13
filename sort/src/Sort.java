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
 */
public class Sort {

    public static void main(String args[]) {
        int[] array = {5, 7, 2, 3, 1, 8, 6, 4, 9};
        System.out.println("Sorting " + Arrays.toString(array));
        System.out.println("Bubble sort is " + Arrays.toString(bubbleSort(array)));
        System.out.println("Insertion sort is " + Arrays.toString(insertionSort(array)));
        System.out.println("Selection sort is " + Arrays.toString(selectionSort(array)));
    }

    public static int[] bubbleSort(int[] nums) {
        int[] sort = nums.clone();

        for (int unsorted = sort.length; unsorted > 0; unsorted--) {
            for (int i = 0; i < unsorted -1; i++) {
                if (sort[i] > sort[i+1]) {
                    int tempVal = sort[i];
                    sort[i] = sort[i+1];
                    sort[i+1] = tempVal;
                }
            }
        }

        return sort;
    }

    public static int[] insertionSort(int[] nums) {
        int[] sort = nums.clone();

        for (int i = 1; i < sort.length; i++) {
            int j = i;
            while (j > 0 && sort[j-1] > sort[j]) {
                // swapping values in nums[j] and nums[j-1]
                int temp = sort[j];
                sort[j] = sort[j-1];
                sort[j-1] = temp;

                j--;
            }
        }

        return sort;
    }

    public static int[] selectionSort(int[] nums) {
        int[] sort = nums.clone();

        for (int pass = 0; pass < sort.length; pass++) {
            int lowestNumI = pass;
            for (int i = pass + 1; i < sort.length; i++) {
                if (sort[lowestNumI] > sort[i]) {
                    lowestNumI = i;
                }
            }
            int lowestNum = sort[lowestNumI];
            sort[lowestNumI] = sort[pass];
            sort[pass] = lowestNum;
        }
        return sort;
    }
}
