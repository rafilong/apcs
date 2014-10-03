/*
 * AP Computer Science Pig Latin Project
 * Code written by Rafi Long
 * See code for documentation
 */

/**
 *
 * @author Rafi Long
 */
public class Word {
    /** The input word */
    private String input;
    /** The translated word */
    public String output;

    /**
     * A constructor for word
     * Sets `output` to be equal to the translated input
     * @param word the input
     */
    public Word(String word) {
        this.input = word;
        this.output = this.translate();
    }

    /**
     * Translates the word
     * @return the translated word
     */
    public String translate() {
        // makes scope of `first` extend out of
        String first;

        // makes what the first character will be uppercase if the word is uppercase
        if (input.substring(0, 1).equals(input.substring(0, 1).toUpperCase())) {
            first = input.substring(1, 2).toUpperCase();
        } else {
            first = input.substring(1, 2);
        }

        // finds the middle and end of the word, making sure the end is lowercase
        String middle = input.substring(2, input.length());
        String last = input.substring(0, 1).toLowerCase();

        // adds all of the parts of the word together, including the "ay"
        return first + middle + last + "ay";
    }
}
