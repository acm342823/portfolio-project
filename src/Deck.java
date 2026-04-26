<<<<<<< Updated upstream
import java.util.Scanner;

/**
 * {@code DeckKernel} enhanced with secondary methods.
 */
public interface Deck extends DeckKernel {

    /**
     * Removes and returns the top {@code num} of {@code this}.
     *
     * @param num
     *            the number of cards to be removed
     * @return the cards removed
     * @updates this
     * @requires |this| >= num
     * @ensures <pre>
     * draw is suffix of this
     * this = #this \ {draw}
     * </pre>
     */
    Card[] drawMult(int num);

    /**
     * Removes the top card and allows the user to input whether it should be
     * placed on the top or bottom of {@code this}.
     *
     * @param num
     *            the number of cards to be reviewed
     * @param scan
     *            the input device
     * @updates this
     * @requires |this| >= num
     * @ensures <pre>
     * top num cards are reassigned to their user-designated positions
     * </pre>
     */
    void scry(int num, Scanner scan);

    /**
     * Adds card with name {@code n} and cost {@code c} to {@code this}, then
     * shuffles it.
     *
     * @param n
     *            the name of the card
     * @param c
     *            the cost of the card
     * @updates this
     * @ensures <pre>
     * a card with name n and cost c is added to this
     * the order of cards in this is random
     * </pre>
     */
    void shuffleIn(String n, String c);

    /**
     * A card within a deck.
     *
     * @mathmodel type Card is modeled by its name and cost
     * @initially <pre>
     * (String name, String cost):
     *  ensures
     *     this.name = name
     *     this.cost = cost
     * </pre>
     */
    interface Card {
        /**
         * Returns this {@code Card}'s name.
         *
         * @return the name
         * @aliases reference returned by {@code name}
         */
        String name();

        /**
         * Return this {@code Card}'s cost.
         *
         * @return the cost
         * @aliases reference returned by {@code cost}
         */
        String cost();
=======
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** */
public class Deck {

    // 0 is bottom, cards.length() is top
    /**
     * Holds the cards in this.
     */
    private List<Card> cards;

    /**
     * Constructor for Deck.
     */
    public Deck() {
        this.cards = new ArrayList<Deck.Card>();
    }

    /**
     * Shuffles the Cards in this.
     */
    public void shuffle() {
        Comparator<Card> comp = new DeckRando();
        this.cards.sort(comp);
    }

    /**
     * Removes and returns the top card of this.
     *
     * @return the top Card of {@code this}
     */
    public Card draw() {
        return this.cards.remove(this.cards.size() - 1);
    }

    /**
     * Adds a card to the top or bottom of this.
     *
     * @param c
     *            the card to be added
     * @param top
     *            if true, card is placed at the top, else at the bottom
     */
    public void add(Card c, boolean top) {
        if (top) {
            this.cards.add(this.cards.size(), c);
        } else {
            this.cards.add(c);
        }
    }

    /**
     * Internal card class for deck.
     */
    public final class Card {

        /**
         * Holds the card name.
         */
        private final String name;

        /**
         * Holds the card cost.
         */
        private final String cost;

        /**
         * Constructor for card.
         *
         * @param n
         *            the card name
         * @param c
         *            the card cost
         */
        private Card(String n, String c) {
            this.name = n;
            this.cost = c;
        }

        /**
         * Returns the name of the card.
         *
         * @return {@code this.name}
         */
        public String name() {
            return this.name;
        }

        /**
         * Returns the cost of the card.
         *
         * @return {@code this.cost}
         */
        public String cost() {
            return this.cost;
        }
    }

    /**
     * Comparator class that sorts in a random order. Note: .compare() == 0 is
     * not the same as .equals().
     */
    private final class DeckRando implements Comparator<Card> {

        /**
         * Constructor for DeckRando.
         */
        private DeckRando() {

        }

        @Override
        public int compare(Card o1, Card o2) {
            final double modifier = 0.5;
            final int radix = 10;
            double returnVal = Math.random();
            returnVal -= modifier;
            returnVal *= radix;
            return ((int) returnVal);
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            We all know what this is for by now, right?
     */
    public static void main(String[] args) {

>>>>>>> Stashed changes
    }
}
