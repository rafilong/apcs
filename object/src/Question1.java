/**
 * Answers to question 1 in ThinkAPJava chapter 15
 * http://www.greenteapress.com/thinkapjava/thinkapjava.pdf
 *
 * Question:
 * Transform merge into an object method, and change mergeSort accordingly.
 * Which version of merge do you prefer?
 *
 * @author Rafi Long
 *
 * Edits by Rafi:
 * - see merge javadocs
 */
public class Question1 extends Deck {

   /**
    * Merges two sorted decks into a new sorted deck.
    *
    * Edits by Rafi
    * 1) removed static keyword
    * 2) removed parameter d1 from the parameter list
    * 3) replaced references to d1 with this
    * 4) renamed d2 in parameter and code to that for readability
    */
    public Deck merge(Deck that) {
        // create the new deck
        Deck result = new Deck(this.cards.length + that.cards.length);

        int choice;    // records the winner (1 means d1, 2 means d2)
        int i = 0;     // traverses the first input deck
        int j = 0;     // traverses the second input deck

        // k traverses the new (merged) deck
        for (int k = 0; k < result.cards.length; k++) {
            choice = 1;

            // if d1 is empty, d2 wins; if d2 is empty, d1 wins; otherwise,
            // compare the two cards
            if (i == this.cards.length)
                choice = 2;
            else if (j == that.cards.length)
                choice = 1;
            else if (this.cards[i].compareTo(that.cards[j]) > 0)
                choice = 2;

            // make the new deck refer to the winner card
            if (choice == 1) {
                result.cards[k] = this.cards[i];  i++;
            } else {
                result.cards[k] = that.cards[j];  j++;
            }
        }
        return result;
    }

}
