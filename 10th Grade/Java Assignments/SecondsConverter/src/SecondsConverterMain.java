/**
 * Write a description of class SecondsConverterMain here.
 *
 * @author Pranav Ananth
 * @version 9/4/2024
 */
public class SecondsConverterMain {
    public static void main(String[] args) {
        SecondsConverter converter = new SecondsConverter();
        System.out.println("50,391 seconds is equivalent to " + converter.secondsToHMS(50391));
        System.out.println("24,328 seconds is equivalent to " + converter.secondsToHMS(24328));
        System.out.println("1,952 seconds is equivalent to " + converter.secondsToHMS(1952));
    }
}