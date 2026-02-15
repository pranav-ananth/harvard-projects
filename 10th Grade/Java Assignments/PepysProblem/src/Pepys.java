/**
 * Which is more likely: at least one 6 in 6 rolls of a fair die,
 * or at least two 6's in 12 rolls of a fair die?
 * DO NOT solve this as a math problem (you can of course). This is a
 * computation problem. Estimate the probabilities through simulation. If you
 * simply return the theoretical/analytical probability calculated
 * mathematically, you will not pass the test cases.
 */

import java.util.Random;

public class Pepys {
    /**
     * @param n the number of simulations (experiments) to run
     *          (A simulation is rolling a die 6 times.)
     * @return the estimated likelihood of rolling at least one 6 in 6 rolls of a
     *         fair die
     */
    public double probAtLeastOneSix(int n) {
        double succeededSims = 0; // to account for the return type being a double
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 6; j++) {
                int number = random.nextInt(6) + 1;
                if(number == 6) {
                    succeededSims++;
                    break;
                }
            }
        }

        return succeededSims/n;
    }

    /**
     * @param n the number of simulations (experiments) to run
     *          (A simulation is rolling a die 12 times.)
     * @return the estimated likelihood of rolling at least two 6's in 12 rolls of a
     *         fair die
     */
    public double probAtLeastTwoSixes(int n) {
        Random random = new Random();
        double succeededSims = 0; // to account for the return type being a double
        for(int i = 0; i < n; i++) {
            int sixCount = 0;

            for(int j = 0; j < 12; j++) {
                int number = random.nextInt(6) + 1;
                if(number == 6) {
                    sixCount++;
                }
            }
            if(sixCount >= 2) {
                succeededSims++;
            }
        }
        return succeededSims/n;
    }

}