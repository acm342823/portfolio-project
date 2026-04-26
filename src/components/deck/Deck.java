package components.deck;

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
    public interface Card {
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
    }
}
