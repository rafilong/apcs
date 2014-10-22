import java.util.Arrays;

/**
 * Answers to question 5 in ThinkAPJava chapter 15
 * http://www.greenteapress.com/thinkapjava/thinkapjava.pdf
 *
 * Chapter 15. Object-oriented programming
 *
 * There are no test cases, as the final questions test all of the functions
 *
 *
 * Questions:
 *
 * 1. Start with http://thinkapjava.com/code/CardSoln3.java and make sure you can compile and run it.
 * See Question1
 *
 *
 * 2. Write a definition for a class named PokerHand that extends Deck.
 * See the creation of the class (hint: it is called PokerHand and it extends Deck).
 *
 *
 * 3. Write a Deck method named deal that creates a PokerHand, transfers cards from the deck to the hand, and returns
 * the hand.
 * See deal().
 *
 *
 * 4. In main use shuffle and deal to generate and print four PokerHands with five cards each. Did you get anything
 * good?
 *
 * I got:
 * Jack of Diamonds, 4 of Clubs, Queen of Hearts, Queen of Clubs, 9 of Hearts
 * Queen of Hearts, 4 of Clubs, 10 of Diamonds, King of Clubs, 3 of Spades
 * Queen of Spades, 2 of Clubs, 6 of Clubs, Ace of Spades, King of Hearts
 * 2 of Hearts, 6 of Spades, 7 of Hearts, 2 of Clubs, 9 of Diamonds
 * This is nothing special
 *
 *
 * 5. Write a PokerHand method called hasFlush returns a boolean indicating whether the hand contains a flush.
 * See hasFlush
 *
 *
 * 6. Write a method called hasThreeKind that indicates whether the hand contains Three of a Kind.
 * See hasThreeKind()
 *
 *
 * 7. Write a loop that generates a few thousand hands and checks whether
 * they contain a flush or three of a kind. Estimate the probability of
 * getting one of those hands. Compare your results to the probabilities
 * at http://en.wikipedia.org/wiki/List_of_poker_hands.
 *
 * With a hundred thousand trials, the results are:
 * The number of flushes is: 198
 * The number of three of a kinds is: 2236
 * The probability of a flush is: 0.198%
 * The probability of a three of a kind is: 2.236%
 *
 * My probability of a flush is off by 0.002%, while the three of a kind is of by 0.126%
 *
 *
 * 8. Write methods that test for the other poker hands. Some are easier
 * than others. You might find it useful to write some general-purpose
 * helper methods that can be used for more than one test.
 * See hasPair, hasFourKind, hasFullHouse, and hasStraight
 *
 *
 * 9. In some poker games, players get seven cards each, and they form a
 * hand with the best five of the seven. Modify your program to generate
 * seven-card hands and recompute the probabilities.
 *
 * With a hundred thousand trials
 * The number of flushes is: 251
 * The number of three of a kinds is: 7520
 * The probability of a flush is: 0.251%
 * The probability of a three of a kind is: 7.5200000000000005%
 *
 * The probability of having a three of a kind went up dramatically, while flush didn't increase that much.
 *
 *
 * @author Rafi Long
 *
 * Edits by Rafi:
 * -
 */
public class PokerHand extends Deck {
    /**
     * The hand
     */
    public Card[] hand = new Card[7];

    /**
     * Empty constructor
     */
    public PokerHand() {}

    /**
     * Main
     * Tests the various parts of the program
     *
     * @param args unused parameter
     */
    public static void main(String args[]) {
        // question 4 testing
        System.out.println("Question 4");
        PokerHand[] hands = new PokerHand[4];

        for (int i = 0; i < hands.length; i++) {
            // initializing hand
            hands[i] = new PokerHand();
            hands[i].shuffle();
            for (int j = 0; j < hands[i].hand.length; j++) {
                hands[i].hand[j] = hands[i].deal().hand[j];
            }

            // printing the hand
            System.out.println(hands[i]);
        }
        System.out.println();

        // question 7 testing
        System.out.println("Question 7");
        PokerHand[] newHands = new PokerHand[100000];
        int flushes = 0;
        int threeKinds = 0;

        for (int i = 0; i < newHands.length; i++) {
            // initializing hand
            newHands[i] = new PokerHand();
            newHands[i].shuffle();
            for (int j = 0; j < newHands[i].hand.length; j++) {
                newHands[i].hand[j] = newHands[i].deal().hand[j];
            }

            // calculating three of a kinds and flushes
            if (newHands[i].hasFlush()) flushes++;
            if (newHands[i].hasThreeKind()) threeKinds++;
        }

        System.out.println("The number of flushes is: " + flushes);
        System.out.println("The number of three of a kinds is: " + threeKinds);
        System.out.println("The probability of a flush is: " + (((double)flushes / (double)newHands.length) * 100) + "%");
        System.out.println("The probability of a three of a kind is: " + (((double)threeKinds / (double)newHands.length) * 100) + "%");
    }

    /**
     * A simple toString that prints all the cards in the hand
     * @return a string of the cards
     */
    public String toString() {
        String retval = "";

        for (int i = 0; i < hand.length; i++) {
            retval += hand[i].toString();
            if (i != hand.length - 1) retval += ", ";
        }

        return retval;
    }

    /**
     * Takes the top 5 cards from the deck
     *
     * @return the hand of 5 cards
     */
    public PokerHand deal() {
        PokerHand pokerHand = new PokerHand();

        for (int i = 0; i < hand.length; i++) {
            pokerHand.hand[i] = cards[i];
        }

        return pokerHand;
    }

    /**
     * Checks whether the cards form a straight
     * @return whether the cards form a straight
     */
    public boolean hasStraight() {
        // moves the ranks of the cards to an array
        int[] ranks = new int[hand.length];
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = hand[i].rank;
        }

        // sorts the array
        Arrays.sort(ranks);

        // the number of cards in order
        int numInOrder = 0;
        for (int i = 0; i < ranks.length - 1; i++) {
            if (ranks[i] == ranks[i+1]) {
                numInOrder++;
            } else if (numInOrder < 5 && ranks[i] != ranks[i+1]) {
                numInOrder = 0;
            }
        }

        //whether there are 5 or more cards in a row
        return numInOrder >= 5;
    }

    /**
     * Checks if there is a flush
     * @return there is a flush
     */
    public boolean hasFlush() {
        int cardsSame = 0;

        // for all cards returns false if the next card is a different suit
        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i].suit == hand[i + 1].suit) cardsSame++;
        }

        // returns true if there has been no false
        return cardsSame >= 5;
    }

    /**
     * Checks whether the hand contains a four of a kind
     * @return whether the hand contains a four of a kind
     */
    public boolean hasFourKind() {
        if (checkNumbers() == 4) return true;
        return false;
    }

    /**
     * Checks whether the hand contains a three of a kind
     * @return whether the hand contains a three of a kind
     */
    public boolean hasThreeKind() {
        if (checkNumbers() == 3) return true;
        return false;
    }

    /**
     * Checks whether the hand contains a pair
     * @return whether the hand contains a pair
     */
    public boolean hasPair() {
        if (checkNumbers() == 2) return true;
        return false;
    }

    /**
     * Checks whether the hand has a full house
     * @return whether the hand has a full house
     */
    public boolean hasFullHouse() {
        // two variables with the number of values that are the same
        // the number of the values that are the same can be 2 and 3 or 2 and 2, so you only need 2 variables
        int same1 = 0;
        int same2 = 0;

        // fills the 2 variables with the number of values that are the same if possible
        for (int i = 0; i < hand.length; i++) {
            int current = sameNumbers(hand[i].rank);
            if (current > 2) {
                if (same1 == 0) {
                    same1 = current;
                } else if (same2 == 0) {
                    same2 = current;
                } else {
                    if (current > same1) {
                        same1 = current;
                    } else if (current > same2) {
                        same2 = current;
                    }
                }
            }
        }

        // returns if there are 3 cards that are the same and 2 cards that are the same
        return same1 + same2 >= 5;
    }

    /**
     * Returns the number of cards that share the same number
     * Note: if 3 cards share a number and 2 shared another, the return will be 3, not 5
     *
     * @return the number of cards that share the same number
     */
    public int checkNumbers() {
        // the number of cards that are the same
        int same = 0;

        // checks to see how many cards share each rank
        // if the number of cards that share a rank is greater than the last card, same is replaced
        for (int i = 0; i < hand.length; i++) {
            int current = sameNumbers(hand[i].rank);
            if (current > same) same = current;
        }

        // same is returned
        return same;
    }

    /**
     * Checks to see how many cards share a number
     * @param number the number that is checked
     * @return the number of cards that share that number
     */
    public int sameNumbers(int number) {
        // the number of cards that are the same
        int same = 0;

        // cycles through all cards,
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].rank == number) {
                same++;
            }
        }

        return same;
    }
}
