/**
 * A string object that I created
 */
public class MyString {
    /** Where all the datum for the string is kept */
    public static Node graph;

    /**
     * A default constructor
     */
    public MyString() {

    }

    /**
     * Adds the character
     * @param c the character to be added
     */
    public void add(Character c) {
        graph.add(c);
    }

    /**
     * Adds all of the characters in the array
     * @param chars the characters to be added
     */
    public void addAll(Character[] chars) {
        for (Character chr : chars) {
            graph.add(chr);
        }
    }

    /**
     * Compiles MyString into a String so it can be more easily used
     * @return a String version of MyString
     */
    public String toString() {
        Node current = graph;
        String retval = (String) current.getDatum();

        while(current.getConnect() != null) {
            current = current.getConnect().getTo();
            retval += current.getDatum();
        }

        return retval;
    }
}
