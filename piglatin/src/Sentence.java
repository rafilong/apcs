/*
 * AP Computer Science Pig Latin Project
 * Code written by Rafi Long
 * See code for documentation
 */

/**
 *
 * @author Rafi Long
 */
public class Sentence {
    public enum Language {
        ENGLISH, PIGLATIN;
    }

    private String input;
    private String output;

    private Language inputLanguage;
    private Language outputLanguage;

    private Word[] sentence;

    public Sentence(String input, Language inputL, Language outputL) {
        this.input = input;
        this.inputLanguage = inputL;
        this.outputLanguage = outputL;


    }
}
