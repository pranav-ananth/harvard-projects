
/**
 * Write a program that determines the change to be dispensed from a vending
 * machine. An item in the machine can cost between 25 cents and 1 dollar, in 5-cent
 * increments (25, 30, 35, . . . , 90, 95, or 100), and the machine accepts only a
 * single dollar bill to pay for the item. For example, a possible sample dialogue
 * might be the following:
 * Enter price of item (from 25 cents to a dollar, in 5-cent increments): 45
 * You bought an item for 45 cents and gave me a dollar, so your change is
 * 2 quarters, 0 dimes, and 1 nickels.
 *
 * @author Pranav Ananth
 * @version 9/11/2024
 */

import java.util.Scanner;

public class ChangeMain {
    public static void main(String[] args) {
        System.out.println("Enter price of item (from 25 cents to a dollar, in 5-cent increments): ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Change change = new Change();
        System.out.println("You bought an item for " + n + " cents and gave me a dollar, so your change is "
                + change.cashInCoins(100-n));
    }

}