/*
 * AP Computer Science Pig Latin Project
 * Code written by Rafi Long
 * See code for documentation
 */

import java.util.ArrayList;

/**
 *
 * @author Rafi Long
 */
public class Sentence {
    /**
     * Unimplemented, supposed to  translate between languages
     * Will add later if we have more time
     */
    public enum Language {
        ENGLISH, PIGLATIN;
    }

    /** The string provided as input */
    private String input;
    /** The translated string */
    public String output;

    /** Unimplemented (see language enum) */
    private Language inputLanguage;
    /** Unimplemented (see language enum) */
    private Language outputLanguage;

    /** All the words in the sentence in their own special object */
    private Word[] sentence;

    /**
     * A constructor for sentence
     * @param input
     */
    public Sentence(String input) {
        this.input = input;

        // adds all of the words to the `sentence` variable
        this.toWord();
        // translates all of the words in the `sentence` variable and sets `output` equal to the result
        output = transcribeTranslation();
    }

    private void toWord() {
        // the start of the word
        int wordStart = 0;
        // the number of words (to find how long to set the array of Words to be)
        int numberOfWords = 0;
        // an arraylist of words
        ArrayList<Word> words = new ArrayList<Word>();

        // separates the words by whether there is a space after them
        for (int i = 0; i < input.length(); i++) {
            // if a character is at the end, the characters from wordStart to it are added
            if (i == input.length()) {
                numberOfWords++;
                words.add(new Word(input.substring(wordStart, i)));
            // if there is a space after a character, the characters from wordStart to it are added and wordStart reset
            } else if (input.substring(i, i+1).equals(" ")) {
                numberOfWords++;
                words.add(new Word(input.substring(wordStart, i)));
                wordStart = i+1;
            }
        }

        // initializes `sentence` to the number of words there are
        sentence = new Word[numberOfWords + 1];

        // adds the words to `sentence`
        for (int i = 0; i < words.size(); i++) {
            sentence[i] = words.get(i);
        }
    }

    /**
     * Takes the translated words (words are translated on initialization), and adds them to output
     * @return
     */
    private String transcribeTranslation() {
        String tSentence = "";

        for (Word word : sentence) {
            tSentence += word.output;
        }

        return tSentence;
    }
}
