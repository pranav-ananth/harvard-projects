
/**
 * Write a description of class QuadraticSolver here.
 *
 * @author Pranav Ananth
 * @version 9/18/2024
 */
public class QuadraticSolver {

    /**
     * returns the roots of ax^2 + bx + c = 0 in the format:
     * "roots are r1 and r2"
     * (where r1 >= r2)
     *
     * if the roots are non-real, returns "no real roots"
     *
     * precondition: a is non-zero
     */
    public String roots(double a, double b, double c) {
        if (a != 0) {
            double discriminant = (b * b) - (4*a*c);
            if (discriminant > 0) { // two roots
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                return "roots are " + root1 + " and " + root2;
            }
            else if (discriminant == 0) { // one root
                double root = -b / (2 * a);
                return "root is " + root;
            }
            else {
                return "no real roots";
            }
        }
        return "a needs to be a number other than 0";
    }
}