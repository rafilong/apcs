/**
 * Attempted implementation of the mapcar function in Java without using Java 8.0
 * Code written by Rafi Long
 * Implementation idea discussed with Alex Tarng
 *
 * How to use this class:
 * 1. Create a class that extends this class
 * 2. Implement method method
 *  - make this method use the intended number of values that will be used when calling mapcar
 * 3. Create a new object of the class you just created
 * 4. Call objectName.mapcar(arguments[], compareToTheseArguments[]), etc
 *  - make sure that all of your arguments are of the same length
 * 5. Have fun!
 */
public abstract class Mapcar {

    /**
     * The class in which the mapcar operation is specified
     * @param values the values which will be compared
     * @return the return of the operation
     */
    public abstract Object method(Object[] values);

    /**
     * This is the function in which the values that are to be called on are placed as arguments
     *
     * Note - all parameters must be arrays of same length
     * @param values all of the values to be used
     *       Note that values separated by commas in invocation will be compared,
     *       while those in a single array will be called on separately
     * @return
     */
    public Object[] mapcar(Object[] ... values) {
        // the return value of the mapcar function
        Object[] retvals = new Object[values[0].length];

        // and iterator through the length of each array input
        for (int i = 0; i < values[0].length; i++) {
            // a new array that will be the input to method
            Object[] input = new Object[values.length];
            // iterating through each value of index i in the separate arrays
            for (int j = 0; j < values.length; j++) {
                // adding that value to the input
                input[j] = values[j][i];
            }
            // setting a retval location to be equal to the return of method
            retvals[i] = method(input);
        }

        // returning the values
        return retvals;
    }
}
