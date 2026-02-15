import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    /** List of all cards */
    private List<Card> cards;


    /** Size is the number of undealt cards
     *  Cards are dealt from the top down at size-1
     */
    private int size;

    /**
     * Initializes a new deck with the given suits, ranks, and values.
     * @param suits - all the suits in the deck
     * @param ranks - all the ranks in the deck
     * @param values - the value of each rank of card
     */
    public Deck(String[] suits, String[] ranks, int[] values) {
        cards = new ArrayList<Card>();
        for(int i = 0; i < suits.length; i++) {
            for(int j = 0; j < ranks.length; j++) {
                cards.add(new Card(suits[i], ranks[j], values[j]));
            }
        }

        size = cards.size();
    }

    /**
     * Determines if the deck is empty.
     * @return true if the deck is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Shuffles the List of Cards for a new game.
     */
    public void shuffle() {
        Collections.shuffle(cards);
        size = cards.size(); // resetting back to the top
    }

    /**
     * Returns the topmost card from the deck not dealt yet.
     * @return the Card at size-1
     */
    public Card deal() {
        if(isEmpty())
            return null;
        size--;
        Card card = cards.get(size);
        return card;
    }
}
