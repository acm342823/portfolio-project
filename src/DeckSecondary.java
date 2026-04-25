import java.util.Scanner;

public abstract class DeckSecondary implements Deck {
    public Deck.Card[] drawMult(int num) {
        Deck.Card[] returnVal = new DeckSecondary.SimpleCard[num];
        for (int i = 0; i < returnVal.length; i++) {
            Deck.Card current = this.draw();
            returnVal[i] = current;
        }
        return returnVal;
    }

    public void scry(int num, Scanner scan) {
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

    public void shuffleIn(String n, String c) {
        this.add(n, c, true);
        this.shuffle();
    }

    class SimpleCard implements Card {
        private name;
        private cost;

        SimpleCard(String n, String c) {
            this.name = n;
            this.cost = c;
        }

        String name() {
            return this.name;
        }

        String cost() {
            return this.cost;
        }
    }
}
