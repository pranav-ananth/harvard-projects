/**
 * Write a description of class SecondsConverter here.
 *
 * @author Pranav Ananth
 * @version 9/4/2024
 */
public class SecondsConverter {
    /**
     * Converts seconds to hours, minutes, and seconds.
     * For example, if seconds = 50391 the method should return the following
     * String:
     * "13 hours, 59 minutes, and 51 seconds"
     *
     * @param seconds number of seconds
     * @return a String represenation in hours, minutes, and seconds
     */

    String secondsToHMS(int seconds) {
        int hours = seconds/3600;
        int minutes = (seconds/60) % 60;
        String finalString = hours + " hours, " + minutes + " minutes, and " + (seconds % 60) + " seconds";
        return finalString;
    }

}