/**
 * Write a description of class TemperatureConverter here.
 *
 * @author Pranav
 * @version 9/4/2024
 */
public class TemperatureConverter {

    /**
     * converts fahrenheit to celsius
     *
     * @param fahr the temperature in fahrenheit
     * @return the temperature in degrees celsius
     */
    public double fToC(double fahr) {
        double cels = (fahr - 32) * 5/9;
        return cels;
    }

}