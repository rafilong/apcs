/*
 * AP Computer Science Pig Latin Project
 * Code written by Rafi Long
 * See code for documentation
 */

/**
 *
 * @author Rafi Long
 */
public class Control {
    /** Whether or not to repeat the program */
    private static boolean repeat = true;

    /**
     * Calls cycle, which prompts the user for a new translation
     * @param args unused parameter
     */
    public static void main(String args[]) {
        while (repeat) {
            cycle();
        }
    }

    /**
     * Goes through a cycle of code, geting
     */
    public static void cycle() {
        // translates the string obtained from prompting the user
        String question = Input.question("Enter what you want to be scanned");
        System.out.println(new Sentence(question).output);

        // asks the user if they want to repeat, and sets repeat to false if they don't
        if (!Input.trueFalse("Do you want to translate again?")) repeat = false;

        // some new lines to make things look better
        System.out.println();
        System.out.println();
    }
}