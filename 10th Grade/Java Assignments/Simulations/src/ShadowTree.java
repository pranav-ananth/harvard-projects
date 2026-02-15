public class ShadowTree {
    public static void main(String[] args) {
        int n1 = 0, n2 = 0, n3 = 0;
        double strength1, strength2, strength3;

        for(int i = 0; i < 30; i++) {
            if(n1 < 10)
                strength1 = (30 * Math.pow(1.5, n1)) / 5;
            else
                strength1 = 100000000;
            if(n2 < 10)
                strength2 = (105 * Math.pow(1.5, n2)) / 10;
            else
                strength2 = 100000000;
            if(n3 < 10)
                strength3 = (150 * Math.pow(1.5, n3)) / 20;
            else
                strength3 = 100000000;


            double min = Math.min(strength1, Math.min(strength2, strength3));

            if (Double.compare(min, strength1) == 0) {
                System.out.println("Strength 1" + " " + (n1+1));
                n1++;
            }
            else if(Double.compare(min, strength2) == 0) {
                System.out.println("Strength 2" + " " + (n2+1));
                n2++;
            }
            else {
                System.out.println("Strength 3" + " " + (n3+1));
                n3++;
            }
        }
    }
}