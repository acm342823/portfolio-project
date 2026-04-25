import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * This wouldn't stop showing up because my other classes and interfaces  are
 * not available in this branch. Please disregard it.
 */
import javax.smartcardio.Card;

/**
 * {@code Deck} represented as a {@link java.util.List java.util.List} with
 * implementations of primary methods.
 *
 * @correspondence this = [value of $this.cards]
 */
public class Deck1 implements DeckKernel {

    /**
     * Representation of {@code this}.
     */
    private List<Card> cards;

    /**
     * No-argument constructor.
     */
    public Deck1() {
        this.cards = new ArrayList<Card>();
    }

    @Override
    public Deck.Card draw() {
        return this.cards.remove(this.cards.size());
    }

    @Override
    public void add(String n, String c, boolean top) {
        Deck.Card add = new SimpleCard(n, c);
        if (top) {
            this.cards.add(add);
        } else {
            this.cards.add(0, add);
        }
    }

    @Override
    public void shuffle() {
        Comparator<Deck.Card> comp = new DeckRandomizer();
        this.cards.sort(comp);
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    /**
     * {@code Comparator} to allow for the randomization of cards in
     * {@code this}. The ordering is not consistent with equals.
     */
    private class DeckRandomizer extends Comparator<Deck.Card> {
        DeckRandomizer() {

        }

        @Override
        int compare(Deck.Card o1, Deck.Card o2) {
            final int radix = 10;
            final int modifier = 0.5;
            double r = Math.random();
            r -= modifier;
            return ((int) r * radix);
        }
    }
}
