import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

public class BlackjackGUI extends JFrame implements ActionListener {

    /** Height of the game frame. */
    private static final int DEFAULT_HEIGHT = 402;
    /** Width of the game frame. */
    private static final int DEFAULT_WIDTH = 1000;
    /** Width of a card. */
    private static final int CARD_WIDTH = 73;
    /** Height of a card. */
    private static final int CARD_HEIGHT = 97;
    /** Distance between the left edge of the first card and the left edge of the second card. */
    private static final int CARD_WIDTH_INC = 80;
    /** x coord of the upper left corner of the first card. */
    private static final int CARD_LEFT = 30;
    /** y coord of the upper left corner of the first card. */
    private static final int CARD_TOP = 60;
    /** Distance between the player's cards and dealer's cards. */
    private static final int CARD_HEIGHT_INC = 125;
    /** x coord of the "Hit" button. */
    private static final int BUTTON_LEFT = 700;
    /** y coord of the "Hit" button. */
    private static final int BUTTON_TOP = 200;
    /** Distance between the sides of the "Hit" and "Stand" buttons. */
    private static final int BUTTON_WIDTH_INC = 120;
    /** Distance between the bottom of the "Hit" and "Play Again" buttons. */
    private static final int BUTTON_HEIGHT_INC = 100;
    /** x coord of the "Bet" field. */
    private static final int FIELD_LEFT = 810;
    /** y coord of the "Bet" field. */
    private static final int FIELD_TOP = 80;
    /** x coord of the "message" labels. */
    private static final int MESSAGE_LEFT = 200;
    /** y coord of the "message" labels. */
    private static final int MESSAGE_TOP = 302;

    /** The main panel containing the game components. */
    private JPanel panel;
    /** The money display. */
    private JLabel moneyLabel;
    /** The hit button. */
    private JButton hitButton;
    /** The stand button. */
    private JButton standButton;
    /** The text field to input your bet. */
    private JTextField betField;
    /** The bet button. */
    private JButton betButton;
    /** The continue playing button. */
    private JButton continueButton;
    /** The quit playing button. */
    private JButton quitButton;
    /** The player's card displays. */
    private List<JLabel> displayPCards;
    /** The dealer's card displays. */
    private List<JLabel> displayDCards;
    /** The enter bet message. */
    private JLabel enterBetMsg;
    /** The successful bet message. */
    private JLabel successfulBetMsg;
    /** The invalid bet message. */
    private JLabel invalidBetMsg;
    /** The player lose message. */
    private JLabel loseMsg;
    /** The player win message. */
    private JLabel winMsg;
    /** The player tie message. */
    private JLabel tieMsg;
    /** The message when you run out of money or quit the game. */
    private JLabel quitMsg;

    /** The main game loop. */
    private BlackjackGame game;

    /**
     * Determines whether you can interact with buttons.
     * If this is set to true, you cannot.
     */
    private boolean gameEnd;

    /**
     * Initializes the GUI and the BlackjackGame.
     */
    public BlackjackGUI() {
        game = new BlackjackGame();
        displayPCards = new ArrayList<JLabel>();
        displayDCards = new ArrayList<JLabel>();
        gameEnd = false;

        initDisplay();
        newRound();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
    }

    /**
     * Initialize the display.
     */
    private void initDisplay() {
        panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };

        this.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        panel.setLayout(null);
        panel.setName("Blackjack");
        panel.setPreferredSize(
                new Dimension(DEFAULT_WIDTH - 20, DEFAULT_HEIGHT - 20));

        JLabel playerCardLabel = new JLabel();
        playerCardLabel.setText("Your Cards");
        panel.add(playerCardLabel);
        playerCardLabel.setBounds(CARD_LEFT, CARD_TOP + CARD_HEIGHT_INC + CARD_HEIGHT + 30, 100, 15);

        JLabel dealerCardLabel = new JLabel();
        dealerCardLabel.setText("Dealer's Cards");
        panel.add(dealerCardLabel);
        dealerCardLabel.setBounds(CARD_LEFT, CARD_TOP - 30, 100, 15);

        moneyLabel = new JLabel();
        moneyLabel.setText("Money: $" + game.getMoney());
        panel.add(moneyLabel);
        moneyLabel.setBounds(FIELD_LEFT - 40, FIELD_TOP - 40, 100, 15);

        JLabel betLabel = new JLabel();
        betLabel.setText("Bet Amount: $");
        panel.add(betLabel);
        betLabel.setBounds(FIELD_LEFT - 80, FIELD_TOP, 80, 15);

        betField = new JTextField();
        panel.add(betField);
        betField.setBounds(FIELD_LEFT, FIELD_TOP, 70, 15);

        betButton = new JButton();
        betButton.setText("Bet");
        panel.add(betButton);
        betButton.setBounds(FIELD_LEFT - 50, FIELD_TOP + 30, 100, 30);
        betButton.addActionListener(this);

        hitButton = new JButton();
        hitButton.setText("Hit");
        panel.add(hitButton);
        hitButton.setBounds(BUTTON_LEFT, BUTTON_TOP, 100, 30);
        hitButton.addActionListener(this);

        standButton = new JButton();
        standButton.setText("Stand");
        panel.add(standButton);
        standButton.setBounds(BUTTON_LEFT + BUTTON_WIDTH_INC, BUTTON_TOP,
                100, 30);
        standButton.addActionListener(this);

        continueButton = new JButton();
        continueButton.setText("Play Again");
        panel.add(continueButton);
        continueButton.setBounds(BUTTON_LEFT, BUTTON_TOP + BUTTON_HEIGHT_INC, 100, 30);
        continueButton.addActionListener(this);

        quitButton = new JButton();
        quitButton.setText("End Game");
        panel.add(quitButton);
        quitButton.setBounds(BUTTON_LEFT + BUTTON_WIDTH_INC, BUTTON_TOP + BUTTON_HEIGHT_INC, 100, 30);
        quitButton.addActionListener(this);

        enterBetMsg = new JLabel();
        enterBetMsg.setFont(new Font("SansSerif", Font.BOLD, 15));
        enterBetMsg.setText("Enter a bet.");
        panel.add(enterBetMsg);
        enterBetMsg.setBounds(MESSAGE_LEFT, MESSAGE_TOP, 300, 30);
        enterBetMsg.setVisible(false);

        successfulBetMsg = new JLabel();
        successfulBetMsg.setFont(new Font("SansSerif", Font.BOLD, 15));
        successfulBetMsg.setText("Successful bet. The round has now started.");
        panel.add(successfulBetMsg);
        successfulBetMsg.setBounds(MESSAGE_LEFT, MESSAGE_TOP, 400, 30);
        successfulBetMsg.setVisible(false);

        invalidBetMsg = new JLabel();
        invalidBetMsg.setFont(new Font("SansSerif", Font.BOLD, 15));
        invalidBetMsg.setText("Invalid bet. Please try again.");
        panel.add(invalidBetMsg);
        invalidBetMsg.setBounds(MESSAGE_LEFT, MESSAGE_TOP, 300, 30);
        invalidBetMsg.setVisible(false);

        winMsg = new JLabel();
        winMsg.setFont(new Font("SansSerif", Font.BOLD, 15));
        winMsg.setText("You won the round and your bet.");
        winMsg.setForeground(Color.GREEN);
        panel.add(winMsg);
        winMsg.setBounds(MESSAGE_LEFT, MESSAGE_TOP, 300, 30);
        winMsg.setVisible(false);

        loseMsg = new JLabel();
        loseMsg.setFont(new Font("SansSerif", Font.BOLD, 15));
        loseMsg.setText("You lost the round and your bet.");
        loseMsg.setForeground(Color.RED);
        panel.add(loseMsg);
        loseMsg.setBounds(MESSAGE_LEFT, MESSAGE_TOP, 300, 30);
        loseMsg.setVisible(false);

        tieMsg = new JLabel();
        tieMsg.setFont(new Font("SansSerif", Font.BOLD, 15));
        tieMsg.setText("You tied the round and kept your bet.");
        panel.add(tieMsg);
        tieMsg.setBounds(MESSAGE_LEFT, MESSAGE_TOP, 300, 30);
        tieMsg.setVisible(false);

        quitMsg = new JLabel();
        quitMsg.setFont(new Font("SansSerif", Font.BOLD, 15));
        quitMsg.setText("You ended up with a total of $" + game.getMoney() + ".");
        panel.add(quitMsg);
        quitMsg.setBounds(MESSAGE_LEFT, MESSAGE_TOP, 300, 30);
        quitMsg.setVisible(false);

        pack();
        getContentPane().add(panel);
        getRootPane().setDefaultButton(hitButton);
        panel.setVisible(true);
    }

    /**
     * Redraws the cards and other changing display elements.
     */
    public void repaint() {
        /** Display dealer cards */
        for (int i = displayDCards.size(); i < game.getNumDCards(); i++) {
            String cardImageFileName =
                    imageFileName(game.getDCardAt(i));
            URL imageURL = getClass().getResource(cardImageFileName);
            if (imageURL != null) {
                ImageIcon icon = new ImageIcon(imageURL);
                displayDCards.add(new JLabel(icon));
                panel.add(displayDCards.get(i));
                displayDCards.get(i).setBounds(CARD_LEFT + (i * CARD_WIDTH_INC), CARD_TOP,
                        CARD_WIDTH, CARD_HEIGHT);
                displayDCards.get(i).setVisible(true);
            } else {
                throw new RuntimeException(
                        "Card image not found: \"" + cardImageFileName + "\"");
            }
        }
        /** Display player cards */
        for (int i = displayPCards.size(); i < game.getNumPCards(); i++) {
            String cardImageFileName =
                    imageFileName(game.getPCardAt(i));
            URL imageURL = getClass().getResource(cardImageFileName);
            if (imageURL != null) {
                ImageIcon icon = new ImageIcon(imageURL);
                displayPCards.add(new JLabel(icon));
                panel.add(displayPCards.get(i));
                displayPCards.get(i).setBounds(CARD_LEFT + (i * CARD_WIDTH_INC), CARD_TOP + CARD_HEIGHT_INC,
                        CARD_WIDTH, CARD_HEIGHT);
                displayPCards.get(i).setVisible(true);
            } else {
                throw new RuntimeException(
                        "Card image not found: \"" + cardImageFileName + "\"");
            }
        }

        moneyLabel.setText("Money: $" + game.getMoney());
        quitMsg.setText("You ended up with a total of $" + game.getMoney() + ".");
        pack();
        panel.repaint();
    }

    /**
     * Runs the game.
     */
    public void displayGame() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }

    /**
     * Returns the image that corresponds to the input card.
     * Image names have the format "[Rank][Suit].GIF",
     * for example, aceclubs.GIF
     *
     * @param c Card to get the image for
     * @return String representation of the image
     */
    private String imageFileName(Card c) {
        String str = "cards/";
        if (c == null) {
            return "cards/back1.GIF";
        }
        str += c.getRank() + c.getSuit();
        str += ".GIF";
        return str;
    }

    /**
     * Responds to a button click on any of the 5 buttons
     * and runs the necessary updates.
     * @param e the button click action event
     */
    public void actionPerformed(ActionEvent e) {
        if(gameEnd) {
            signalError();
        }
        else {
            if(e.getSource().equals(betButton)) {
                enterBetMsg.setVisible(false);
                if(game.getBet() != -1) {
                    signalError();
                }
                else {
                    try {
                        int bet = Integer.parseInt(betField.getText());
                        game.setBet(bet);
                        if(game.getBet() == -1) {
                            signalError();
                            invalidBetMsg.setVisible(true);
                        }
                        else {
                            invalidBetMsg.setVisible(false);
                            successfulBetMsg.setVisible(true);
                        }
                    }
                    catch(NumberFormatException exception) {
                        signalError();
                        invalidBetMsg.setVisible(true);
                    }
                }

            }
            else if(e.getSource().equals(hitButton)) {
                if(game.getBet() < 0) {
                    signalError();
                }
                else {
                    successfulBetMsg.setVisible(false);
                    playPlayerRound();
                }
            }
            else if(e.getSource().equals(standButton)) {
                if(game.getBet() < 0) {
                    signalError();
                }
                else {
                    if(game.getNumPCards() == 0) {
                        signalError();
                    }
                    else {
                        successfulBetMsg.setVisible(false);
                        playDealerRounds();
                        determineWinner();
                    }

                }
            }
            else if(e.getSource().equals(continueButton)) {
                if(game.getBet() != -2) {
                    signalError();
                }
                else if(game.getMoney() == 0) {
                    endGame();
                }
                else {
                    newRound();
                }
            }
            else if(e.getSource().equals(quitButton)) {
                if(game.getBet() != -2) {
                    signalError();
                }
                else {
                    endGame();
                }
            }
        }

    }

    /**
     *  Displays the correct message of who won.
     */
    private void determineWinner() {
        int winner = game.determineWinner();
        if(winner == 1) {
            winMsg.setVisible(true);
        }
        else if(winner == -1) {
            loseMsg.setVisible(true);
        }
        else {
            tieMsg.setVisible(true);
        }
        repaint();
    }

    /**
     * Calls BlackjackGame to draw a card to the player's hand
     * and draws it in the gui.
     */
    private void playPlayerRound() {
        int action = game.playPlayerRound();
        repaint();
        if(action == 1) {
            playDealerRounds();
            determineWinner();
        }
        else if(action == -1) {
            determineWinner();
        }
    }

    /**
     * Calls BlackjackGame to draw all cards to the dealer's hand
     * and draws it in the gui.
     */
    private void playDealerRounds() {
        int dealerAction = 0;
        do {
            dealerAction = game.playDealerRound();

            repaint();
        } while(dealerAction == 0);
    }

    /**
     * Calls BlackjackGame to reset values for a new round
     * and resets the gui.
     */
    private void newRound() {
        winMsg.setVisible(false);
        loseMsg.setVisible(false);
        tieMsg.setVisible(false);
        enterBetMsg.setVisible(true);

        /** removing old cards */
        for (JLabel label : displayPCards) {
            panel.remove(label);
        }
        for (JLabel label : displayDCards) {
            panel.remove(label);
        }

        displayPCards.clear();
        displayDCards.clear();

        game.newRound();
        repaint();
    }

    /**
     * Ends the game and makes all buttons not interactible
     * after manually quitting or running out of money.
     */
    private void endGame() {
        winMsg.setVisible(false);
        loseMsg.setVisible(false);
        tieMsg.setVisible(false);

        signalError();
        repaint();
        quitMsg.setVisible(true);
        gameEnd = true;
    }

    /**
     * Play a sound when an error occurs.
     */
    private void signalError() {
        Toolkit t = panel.getToolkit();
        t.beep();
    }

    /**
     * Plays the GUI for the BlackjackGame.
     * @param args is not used
     */
    public static void main(String[] args) {
        BlackjackGUI game = new BlackjackGUI();
        game.displayGame();
    }
}
