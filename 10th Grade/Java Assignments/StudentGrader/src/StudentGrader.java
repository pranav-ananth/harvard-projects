import java.util.Scanner;

public class StudentGrader{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the three quiz scores: ");
        int quiz1 = scanner.nextInt();
        int quiz2 = scanner.nextInt();
        int quiz3 = scanner.nextInt();
        System.out.print("Enter the midterm score: ");
        int midterm = scanner.nextInt();
        System.out.print("Enter the final exam score: ");
        int finalQuiz = scanner.nextInt();

        StudentRecord studentRecord = new StudentRecord(name, quiz1, quiz2, quiz3, midterm, finalQuiz);
        System.out.print("\nStudentRecord created...\n" + studentRecord.toString());
    }
}