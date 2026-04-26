package components.deck;

import components.standard.Standard;

/**
 * Deck kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.))
 *
 * @mathdefinitions <pre>
 * this contains a number of cards in a particular order
 * this can have repeat cards
 * </pre>
 * @initially <pre>
 * ():
 *  ensures
 *   this = {}
 * </pre>
 */
public interface DeckKernel extends Standard<Deck> {

    /**
     * Removes the top card from {@code this}.
     *
     * @return the card removed
     * @updates this
     * @requires |this| > 0
     * @ensures <pre>
     * draw is suffix of this
     * this = #this \ {draw}
     * </pre>
     */
    Deck.Card draw();

    /**
     * Adds card to the top or bottom of {@code this}.
     *
     * @param n
     *            the name of the card to be added
     * @param c
     *            the cost of the card to be added
     * @param top
     *            whether the card is to be placed at the top
     * @updates this
     * @ensures <pre>
     * [if top is true, a card with name n and cost c is placed at the top of this;
     *   otherwise it is placed at the bottom]
     * this = #this union c
     * </pre>
     */
    void add(String n, String c, boolean top);

    /**
     * Randomizes the positions of cards in {@code this}.
     *
     * @updates this
     * @ensures the order of cards in this is random
     */
    void shuffle();

    /**
     * Returns the size of {@code this}.
     *
     * @return the number of cards in {@code this}
     * @ensures size = |this|
     */
    int size();
}
