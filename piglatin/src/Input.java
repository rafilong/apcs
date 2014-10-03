/*
 * AP Computer Science Pig Latin Project
 * Code written by Rafi Long
 * See code for documentation
 */

import java.util.Scanner;

/**
 * Gets user input for questions, including sentence answer and yes/no
 * @author Rafi Long
 */
public class Input {

    /**
     * Returns the text entered by the user
     * @return the text entered
     */
    public static String getNewString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Asks a question to the user and returns text answer
     * @param message the question
     * @return the answer
     */
    public static String question(String message) {
        System.out.println(message);
        return getNewString();
    }

    /**
     * Asks a true false question that can be answered with "yes" and "no"
     * @param message the question
     * @return the true / false answer
     */
    public static String multipleChoiceQuestion(String message, String[] possibleAnswers) {
        String listAnswers = "";
        for (String possibleAnswer : possibleAnswers) {
            listAnswers += possibleAnswer + "/";
        }
        message += " (" + listAnswers + ")";
        String str = question(message);

        for (String possibleAnswer : possibleAnswers) {
            if (str.equals(possibleAnswer)) {
                return possibleAnswer;
            }
        }

        System.out.println("Please enter " + listAnswers);
        System.out.println();
        return multipleChoiceQuestion(message, possibleAnswers);
    }

    public static boolean trueFalse(String message) {
        String answer = multipleChoiceQuestion(message, new String[] {"yes", "no"});

        return answer.equals("true");
    }
}