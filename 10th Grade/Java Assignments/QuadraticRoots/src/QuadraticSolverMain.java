
/**
 * Write a program that calculates the real roots of a quadratic polynomial
 * in the form ax^2 + bx + c = 0. Prompt the user for input.
 *
 * For example, a possible sample dialogue might be the following:
 * Enter coefficients for the quadratic ax^2 + bx + c = 0.
 * a = 1
 * b = 0
 * c = -4
 *
 * roots are 2.0 and -2.0
 *
 * If the quadratic has no real roots, output "no real roots"
 *
 *
 * @author Pranav Ananth
 * @version 9/18/2024
 */

import java.util.Scanner;

public class QuadraticSolverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuadraticSolver solver = new QuadraticSolver();
        System.out.println("Enter coefficients for the quadratic ax^2 + bx + c = 0.");
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");
        double c = scanner.nextDouble();
        System.out.println("\n" + solver.roots(a, b, c));
    }
}