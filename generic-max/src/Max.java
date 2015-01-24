import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Generic Max Homework
 * Coded by Rafi Long
 *
 * Finds the maximum of a collection using an iterator and values that extend Comparable.
 * Run the program to see test cases.
 */
public class Max {

    /**
     * Tests findMax
     * @param args unused parameter
     */
    public static void main(String args[]) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(1);
        values.add(119);
        values.add(123);
        System.out.println("Finding the max of values 1, 119, and 123");
        System.out.println("The max is: " + findMax(values));
        System.out.println();


        values.add(99999);
        System.out.println("Finding the max of values 1, 119, 123, and 123408");
        System.out.println("The max is: " + findMax(values));
    }

    /**
     * Finds the max of the collection using Comparable and Iterator
     *
     * @param values the collection of values
     * @param <T> a variable that is comparable
     * @return the maximum value
     */
    public static <T extends Comparable> T findMax(Collection<T> values) {
        Iterator<T> iterator = values.iterator();
        T max = null;
        T current;

        // removes errors if values is empty
        if (iterator.hasNext()) {
            max = iterator.next();
        }

        // iterates through all values and
        while (iterator.hasNext()) {
            current = iterator.next();

            if (max.compareTo(current) < 0) {
                max = current;
            }
        }

        return max;
    }
}
