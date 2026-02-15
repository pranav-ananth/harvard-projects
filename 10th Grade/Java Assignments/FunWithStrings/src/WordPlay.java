import java.util.Scanner;
/**
 * This program will demonstrate using the string class with input/output.
 *
 * @author Pranav Ananth
 * @version 8/28/2024
 */

public class WordPlay {
    public static void main(String[] args) {
        System.out.println("Enter a string: ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println("Enter a string to remove: ");
        String remove = input.nextLine();

        int index = str.indexOf(remove);
        String result = str.substring(0, index) + str.substring(index + remove.length());
        System.out.println(result);
    }
}
