import java.util.List;
import java.util.ArrayList;

public class BlackjackGame {
    /** The suits of the cards */
    private static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};

    /** The ranks of the cards */
    private static final String[] RANKS = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /** The values of the cards */
    private static final int[] VALUES = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    /** The amount of money you have */
    private int money;
    /**
     * The amount you have bet on the game.
     * Value is -1 if the game has yet to start(need to enter a bet),
     * and is -2 if the game has concluded(need to click play again or quit).
     */
    private int bet;

    /** The deck the game is played with */
    private Deck deck;
    /** The cards currently in the player's hand */
    private List<Card> playerCards;
    /** The cards currently in the dealer's hand */
    private List<Card> dealerCards;

    /**
     * Creates a new BlackjackGame instance.
     */
    public BlackjackGame() {
        playerCards = new ArrayList<>();
        dealerCards = new ArrayList<>();
        deck = new Deck(SUITS, RANKS, VALUES);
        money = 500;

        newRound();
    }

    /**
     * Resets all the variables for a new blackjack round.
     */
    public void newRound() {
        playerCards.clear();
        dealerCards.clear();

        deck.shuffle();
        bet = -1;
    }

    /**
     * Determines if the given bet is legal, and if it is,
     * sets the bet value to the given value.
     * @param bet
     * @return true if the bet is valid, false otherwise
     */
    public boolean setBet(int bet) {
        if(bet <= money && bet > 0) {
            this.bet = bet;
            return true;
        }
        return false;
    }

    /**
     * Accesses this BlackjackGame's bet.
     * @return this BlackjackGame's bet
     */
    public int getBet() {
        return bet;
    }

    /**
     * Accesses this BlackjackGame's money.
     * @return this BlackjackGame's money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Accesses the number of cards in the player's hand.
     * @return the number of cards in the player's hand
     */
    public int getNumPCards() {
        return playerCards.size();
    }

    /**
     * Accesses the Card at a specific index of playerCards.
     * @param index
     * @return the Card at index of playerCards
     */
    public Card getPCardAt(int index) {
        return playerCards.get(index);
    }

    /**
     * Accesses the number of cards in the dealer's hand.
     * @return the number of cards in the dealer's hand
     */
    public int getNumDCards() {
        return dealerCards.size();
    }

    /**
     * Accesses the Card at a specific index of dealerCards.
     * @param index
     * @return the Card at index of dealerCards
     */
    public Card getDCardAt(int index) {
        return dealerCards.get(index);
    }

    /**
     * Returns the value of all the cards in a List of Cards.
     * If the value is over 21, an ace's value changes from 11 to 1
     * until the value is under 21 or until there are no more aces in the List.
     * @param handCards
     * @return value of all the cards in handCards
     */
    public int getValue(List<Card> handCards) {
        int value = 0;
        int numAces = numAces(handCards);
        for(int i = 0; i < handCards.size(); i++) {
            value += handCards.get(i).getValue();
        }

        while(value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    /**
     * Returns the number of aces in a List of Cards.
     * @param handCards
     * @return the number of aces in handCards
     */
    private int numAces(List<Card> handCards) {
        int numAces = 0;
        for(int i = 0; i < handCards.size(); i++) {
            Card card = handCards.get(i);
            if(card.getRank().equals("ace")) {
                numAces++;
            }
        }
        return numAces;
    }

    /**
     * Deals a card and adds it to the player's hand.
     * @return 1 if the player hits 21, -1 if the player busts,
     * and 0 otherwise.
     */
    public int playPlayerRound() {
        Card dealtCard = deck.deal();
        playerCards.add(dealtCard);

        if(getValue(playerCards) > 21) {
            return -1;
        }
        if(getValue(playerCards) == 21) {
            return 1;
        }

        return 0;
    }

    /**
     * Deals a card and adds it to the dealer's hand.
     * @return 1 if the dealer hits over 17, -1 if the dealer busts,
     * and 0 otherwise.
     */
    public int playDealerRound() {
        Card dealtCard = deck.deal();
        dealerCards.add(dealtCard);

        if(getValue(dealerCards) > 21) {
            return -1;
        }
        if(getValue(dealerCards) >= 17) {
            return 1;
        }

        return 0;
    }

    /**
     * Determines the winner after all cards have been added to both hands.
     * @return 1 if the player won, -1 if the player lost,
     * and 0 if the player tied.
     */
    public int determineWinner() {
        if(getValue(playerCards) > 21) {
            money -= bet;
            bet = -2; // to signal the round is over
            return -1;
        }
        if(getValue(dealerCards) > 21) {
            money += bet;
            bet = -2;
            return 1;
        }
        if(getValue(playerCards) > getValue(dealerCards)) {
            money += bet;
            bet = -2;
            return 1;
        }
        if(getValue(playerCards) < getValue(dealerCards)) {
            money -= bet;
            bet = -2;
            return -1;
        }

        /** Dealer and player tied */
        bet = -2;
        return 0;
    }
}
