public class Card {
    private String suit;
    private String rank;
    private int value;

    /**
     * Initializes a new Card with a rank, suit, and point value.
     * @param suit
     * @param rank
     * @param value
     */
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    /**
     * Accesses the Card's suit.
     * @return the Card's suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Accesses the Card's rank.
     * @return the Card's rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Accesses the Card's point value.
     * @return the Card's value
     */
    public int getValue() {
        return value;
    }
}
