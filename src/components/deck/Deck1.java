package components.deck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * {@code Deck} represented as a {@link java.util.List java.util.List} with
 * implementations of primary methods.
 *
 * @correspondence this = [value of $this.cards]
 */
public class Deck1 extends DeckSecondary {

    /**
     * Representation of {@code this}.
     */
    private List<Card> cards;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.cards = new ArrayList<Card>();
    }

    /**
     * No-argument constructor.
     */
    public Deck1() {
        this.createNewRep();
    }

    @Override
    public final Card draw() {
        assert this.size() > 0 : "Violation of: this /= empty_set";
        return this.cards.remove(this.cards.size());
    }

    @Override
    public final void add(String n, String c, boolean top) {
        assert n != null : "Violation of: n is not null";
        assert c != null : "Violation of: c is not null";
        Card add = new SimpleCard(n, c);
        if (top) {
            this.cards.add(add);
        } else {
            this.cards.add(0, add);
        }
    }

    @Override
    public final void shuffle() {
        Comparator<Deck.Card> comp = new DeckRandomizer();
        this.cards.sort(comp);
    }

    @Override
    public final int size() {
        return this.cards.size();
    }

    @Override
    public final Deck newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Deck source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Deck1 : "Violation of: source is of dynamic type Deck1";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case: source must be of dynamic type Deck1 or the
         * call would not have compiled.
         */
        Deck1 localSource = (Deck1) source;
        this.cards = localSource.cards;
        localSource.createNewRep();
    }

    /**
     * {@code Comparator} to allow for the randomization of cards in
     * {@code this}. The ordering is not consistent with equals.
     */
    private class DeckRandomizer implements Comparator<Deck.Card> {
        /**
         * No-argument constructor.
         */
        DeckRandomizer() {

        }

        @Override
        public int compare(Deck.Card o1, Deck.Card o2) {
            final int radix = 10;
            final double modifier = 0.5;
            double r = Math.random();
            r -= modifier;
            return ((int) r * radix);
        }
    }
}
