/**
 * A class that finds the common prefix between two strings
 */
public class Prefix {

    /**
     * Tests common()
     * @param args unused parameter
     */
    public static void main(String args[]) {
        System.out.println("Finding the common prefix between \"hello\" and \"hehaw\"");
        System.out.println(common("hello", "hehaw"));

        System.out.println();

        System.out.println("Finding the common prefix between \"previous\" and \"predetermined\"");
        System.out.println(common("previous", "predtermined"));
    }

    /**
     * Finds the common prefix between two strings
     *
     * @param a the first string
     * @param b the second string
     * @return the common prefix between a and b
     */
    public static String common(String a, String b) {
        // finds the length of the shorter string
        int end = Math.min(a.length(), b.length());

        // an empty string to hold the common values between the two strings
        String retval = "";

        // iterates for the length of the shorter string
        for (int i = 0; i < end; i++) {
            // if the characters are the same add it to retval
            if (a.substring(i, i+1).equals(b.substring(i, i+1))) {
                retval += a.substring(i , i+1);
            // if the characters are different skip to the end
            } else {
                i = end;
            }
        }

        // the common characters between the two in order
        return retval;
    }
}
