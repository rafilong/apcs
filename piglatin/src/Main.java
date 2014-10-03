/*
 * AP Computer Science Pig Latin Project
 * Code written by Rafi Long
 * See code for documentation
 */

/**
 *
 * @author Rafi Long
 */
public class Main {
    private static boolean repeat = true;

    public static void main(String args[]) {
        while (repeat) {
            cycle();
        }
    }

    public static void cycle() {
        System.out.println(Input.question("Enter what you want to be scanned"));
        if (!Input.trueFalse("Do you want to translate again?")) repeat = false;

        System.out.println();
        System.out.println();
    }
}
