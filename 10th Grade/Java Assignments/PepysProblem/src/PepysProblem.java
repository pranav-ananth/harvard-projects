
/**
 * Which is more likely: at least one 6 in 6 rolls of a fair die,
 * or at least two 6's in 12 rolls of a fair die?
 *
 * Write a program that runs a simulation to estimate these probabilities.
 *
 * from Wikipedia:
 * The Newton–Pepys problem is a probability problem concerning the probability of
 * throwing sixes from a certain number of dice. In 1693 Samuel Pepys and Isaac Newton
 * corresponded over a problem posed by Pepys (pronunced "peeps") in relation to a wager
 * he planned to make. The problem was:

 * Which of the following three propositions has the greatest chance of success?
 *
 * A. Six fair dice are tossed independently and at least one “6” appears.
 * B. Twelve fair dice are tossed independently and at least two “6”s appear.
 * C. Eighteen fair dice are tossed independently and at least three “6”s appear.
 *
 * Pepys initially thought that outcome C had the highest probability, but Newton
 * correctly concluded that outcome A actually has the highest probability.
 *
 * https://en.wikipedia.org/wiki/Newton%E2%80%93Pepys_problem
 *
 * @author (your name)
 * @version (a version number or a date)
 *
 * Sample run 1:
 *
 *      Welcome to the Pepys Problem.
 *      Enter the number of simulations to run: 1000000
 *      The empirical probability of rolling at least one six if six dice are rolled is: 0.664918
 *      The empirical probability of rolling at least two sixes if 12 dice are rolled is: 0.618532
 *
 * Sample run 2:
 *
 *      Welcome to the Pepys Problem.
 *      Enter the number of simulations to run: 10000
 *      The empirical probability of rolling at least one six if six dice are rolled is: 0.6619
 *      The empirical probability of rolling at least two sixes if 12 dice are rolled is: 0.6209
 *
 */

import java.util.Scanner;

public class PepysProblem {
    public static void main(String[] args) {
        Pepys pepys = new Pepys();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Pepys Problem.");
        System.out.print("Enter the number of simulations to run: ");
        int n = scanner.nextInt();
        System.out.println("The empirical probability of rolling at least one six if six dice are rolled is: " + pepys.probAtLeastOneSix(n));
        System.out.println("The empirical probability of rolling at least two sixes if 12 dice are rolled is: " + pepys.probAtLeastTwoSixes(n));
    }
}