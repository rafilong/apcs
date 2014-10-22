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
 * - see mergeSort javadocs
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

   /*
    * Sort the Deck using merge sort.
    *
    * Edits by Rafi:
    * 1) replaced the invocation of the static merge with the object merge in Question1
    *
    * Bugs:
    * The program tries to invoke Deck's merge, not the Question1 merge. This is because d1 is of type Deck,
    * not Question1, so calling d1.merge invokes Deck.merge. This could be fixed by changing the type of d1 to Deck,
    * but this introduces a new problem that subdeck() and mergesort() return type Deck. I fixed this by adding a
    * cast to both instances. This will make the program work, but it is a cheap workaround. A good way of fixing
    * this might be to change the return type on the conflicting classes, or to just copy-paste all of CardSoln3 into
    * Question1 and change the functions specified. However, This leaves the user unsure of what methods have been
    * edited, so instead I used this fix, even with the problems it has.
    */
    public Deck mergeSort() {
        if (cards.length < 2) {
            return this;
        }
        int mid = (cards.length-1) / 2;

        // divide the deck roughly in half
        Question1 d1 = (Question1) subdeck(0, mid);
        Deck d2 = subdeck(mid+1, cards.length-1);

        // sort the halves
        d1 = (Question1) d1.mergeSort();
        d2 = d2.mergeSort();

        // merge the two halves and return the result
        // (d1 and d2 get garbage collected)
        return d1.merge(d2);
    }
}
