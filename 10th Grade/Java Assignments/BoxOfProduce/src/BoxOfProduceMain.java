import java.util.Scanner;

public class BoxOfProduceMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoxOfProduce produceBox = new BoxOfProduce("produce.txt");

        System.out.println("There are five items this week: " + produceBox.toString());
        System.out.println("Your box contains: " + produceBox.randomToString());

        System.out.print("Would you like to make a substitution?(y/n) ");
        String confirmation = scanner.nextLine();
        if(confirmation.equals("y")) {
            System.out.print("What item would you like to substitute? ");
            String replaced = scanner.nextLine();
            System.out.print("What would you like to replace it with? ");
            String replacement = scanner.nextLine();
            if(produceBox.replace(replaced, replacement))
                System.out.println("Here is your new order: " + produceBox.randomToString());
            else
                System.out.println("Your item you wanted to substitute was not in your produce box.");
        }

    }

}