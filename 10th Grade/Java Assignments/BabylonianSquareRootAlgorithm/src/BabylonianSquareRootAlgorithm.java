
/**
 * The Babylonian algorithm to compute the square root of a positive number n is as follows:
 * 1. Make a guess at the answer (you can pick n/2 as your initial guess).
 * 2. Compute r = n / guess
 * 3. Set guess = (guess +r)/ 2
 * 4. Go back to step 2 for as many iterations as necessary. The more you repeat steps
 * 2 and 3, the closer guess will become to the square root of n.
 * Write a program that inputs a double for n, iterates through the Babylonian algorithm
 * five times, and outputs the answer as a double. Your
 * answer will be most accurate for small values of n.
 *
 * @author Pranav Ananth
 * @version 9/11/2024
 */

import java.util.Scanner;

public class BabylonianSquareRootAlgorithm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        double n = scanner.nextDouble();
        Babylonian babylonian = new Babylonian();
        double guess = babylonian.squareRoot(n);
        System.out.println("The square root of " + n + " is approximately " + guess);
        System.out.println("The actual square root is " + Math.sqrt(n));

    }

}