
/**
 * Write a program that reads in a line of text and then outputs that line of text with
 * the first occurrence of "hate" changed to "love". For example, a possible sample
 * dialogue might be the following:
 * Enter a line of text.
 * I hate you.
 * I have rephrased that line to read:
 * I love you.
 * If the word "hate" does not appear in the sentence, simply return the original String.
 * If the word "hate"occurs more than once in the line,
 * your program should replace only the first occurrence of "hate".
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class LoveMain {
    public static void main(String[] args) {
        Love loveStr = new Love();
        System.out.println("Enter a line of text.");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("I have rephrased that line to read: \n" + loveStr.loveNotHate(str));
    }

}