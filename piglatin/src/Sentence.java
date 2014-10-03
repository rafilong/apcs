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

    private String input;
    public String output;

    /** Unimplemented (see language enum) */
    private Language inputLanguage;
    /** Unimplemented (see language enum) */
    private Language outputLanguage;

    private Word[] sentence;

    public Sentence(String input, Language inputL, Language outputL) {
        this.input = input;
        this.inputLanguage = inputL;
        this.outputLanguage = outputL;

        this.toWord();
        output = translateAll();
    }

    private void toWord() {
        int wordStart = 0;
        int numberOfWords = 0;

        ArrayList<Word> words = new ArrayList<Word>();

        for (int i = 0; i < input.length(); i++) {
            if (i == input.length()) {
                numberOfWords++;
                words.add(new Word(input.substring(wordStart, i)));
            } else if (input.substring(i, i+1).equals(" ")) {
                numberOfWords++;
                words.add(new Word(input.substring(wordStart, i)));
                wordStart = i+1;
            }
        }

        sentence = new Word[numberOfWords + 1];

        for (int i = 0; i < words.size(); i++) {
            sentence[i] = words.get(i);
        }
    }

    private String translateAll() {
        String tSentence = "";

        for (Word word : sentence) {
            tSentence += word.output;
        }

        return tSentence;
    }
}
