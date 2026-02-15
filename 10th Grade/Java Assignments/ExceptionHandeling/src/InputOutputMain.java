import java.util.Scanner;
import java.util.InputMismatchException;


public class InputOutputMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //scanner.close();
        int n;
        while (true) {
            try {
                System.out.print("Enter a value for how many integers you want: ");
                n = scanner.nextInt();

                if(n <= 0) {
                    throw new IllegalArgumentException("Invalid input. Please enter a positive integer.");
                }
                break;
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println("Invalid input.");
                System.out.println(e);
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

        int[] numbers = new int[n];
        double average = 0;
        while (true) {
            try {
                System.out.print("Enter " + n + " integers : ");
                for(int i = 0; i < n; i++) {
                    numbers[i] = scanner.nextInt();
                    average += numbers[i];
                }
                average /= n;
                System.out.println("The average of all your numbers is " + average + ".");
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // clear out the input buffer
            }
            catch (Exception e){
                System.out.println("invalid input");
                System.out.println(e);
                System.out.println(e.getMessage());
                scanner.nextLine(); // clear out the newline character that is left behind in the input stream
            }
        }
        System.out.println("goodbye");
    }
}
