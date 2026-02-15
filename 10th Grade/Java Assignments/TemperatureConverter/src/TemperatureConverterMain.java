/**
 * Write a description of class TemperatureConverterMain here.
 *
 * @author Pranav
 * @version 9/4/2024
 */
public class TemperatureConverterMain {
    public static void main(String[] args) {

        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("212 degrees Fahrenheit is equivalent to " +
                converter.fToC(212) + " degrees Celsius.");

        System.out.println("32 degrees Fahrenheit is equivalent to " +
                converter.fToC(32) + " degrees Celsius.");

        System.out.println("-40 degrees Fahrenheit is equivalent to " +
                converter.fToC(-40) + " degrees Celsius.");
    }
}