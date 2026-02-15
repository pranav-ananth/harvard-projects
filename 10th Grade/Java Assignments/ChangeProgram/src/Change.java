
/**
 * Write a description of class Change here.
 *
 * @author Pranav Ananth
 * @version 9/11/2024
 */
public class Change {

    /**
     * converts cents to quarters, dimes, nickels
     *
     * precondition: cents is between 0 and 75, inclusive
     *
     * @param cents the number of cents
     * @return a String in the form "q quarters, d dimes, and n nickels"
     */
    public String cashInCoins(int cents) {
        int q = cents/25;
        int d = (cents % 25)/10;
        int n = ((cents % 25) % 10)/5;
        return q + " quarters, " + d + " dimes, and " + n + " nickels";
    }

}