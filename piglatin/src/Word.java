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

    private String original;

    public String output;

    public Word(String word) {
        this.original = word;
        this.output = this.translate();
    }

    public String translate() {
        // makes scope of `first` extend out of
        String first;

        // makes what the first character will be uppercase if the word is uppercase
        if (original.substring(0, 1).equals(original.substring(0, 1).toUpperCase())) {
            first = original.substring(1, 2).toUpperCase();
        } else {
            first = original.substring(1, 2);
        }

        // finds the middle and end of the word, making sure the end is lowercase
        String middle = original.substring(2, original.length());
        String last = original.substring(0, 1).toLowerCase();

        // adds all of the parts of the word together, including the "ay"
        return first + middle + last + "ay";
    }
}
