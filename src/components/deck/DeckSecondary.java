package components.deck;

import java.util.Scanner;

/**
 * Layered implementations of secondary methods for {@code Deck}.
 */
public abstract class DeckSecondary implements Deck {

    @Override
    public final Deck.Card[] drawMult(int num) {
        assert this.size() >= num : "Violation of: |this| is >= num";
        Deck.Card[] returnVal = new DeckSecondary.SimpleCard[num];
        for (int i = 0; i < returnVal.length; i++) {
            Deck.Card current = this.draw();
            returnVal[i] = current;
        }
        return returnVal;
    }

    @Override
    public final void scry(int num, Scanner scan) {
        assert scan != null : "Violation of: scan is not null";
        assert this.size() >= num : "Violation of: |this| is >= num";
        for (int i = 0; i < num; i++) {
            Deck.Card current = this.draw();
            System.out.print("Should the card " + current.name()
                    + " be put on the top or bottom? Enter 1 for top or 2 for bottom: ");
            String response = scan.nextLine();
            while (!response.equals("1") && !response.equals("2")) {
                System.out.print("Please enter 1 or 2: ");
                response = scan.nextLine();
            }
            if (response.equals("1")) {
                this.add(current.name(), current.cost(), true);
            } else {
                this.add(current.name(), current.cost(), false);
            }
        }
    }

    @Override
    public final void shuffleIn(String n, String c) {
        assert n != null : "Violation of n is not null";
        assert c != null : "Violation of c is not null";
        this.add(n, c, true);
        this.shuffle();
    }

    /**
     * Straightforward implementation of the {@code Card} interface.
     */
    protected static final class SimpleCard implements Card {

        /**
         * The name of the card.
         */
        private final String name;

        /**
         * The cost of the card.
         */
        private final String cost;

        /**
         * Constructor.
         *
         * @param n
         *            the name
         * @param c
         *            the cost
         */
        SimpleCard(String n, String c) {
            assert n != null : "Violation of n is not null";
            assert c != null : "Violation of c is not null";
            this.name = n;
            this.cost = c;
        }

        @Override
        public String name() {
            return this.name;
        }

        @Override
        public String cost() {
            return this.cost;
        }
    }
}
