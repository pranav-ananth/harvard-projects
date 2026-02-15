/**
 * Grading Program
 * Write a grading program for a class with the following grading policies:
 *
 * a. There are three quizzes, each graded on the basis of 100 points.
 * The lowest quiz score is dropped.
 *
 * b. There is one midterm exam, graded on the basis of 100 points.
 *
 * c. There is one final exam, graded on the basis of 100 points.
 *
 * The final exam counts for 45% of the grade. The midterm counts for 35% of the grade.
 * The three quizzes together count for a total of 20% of the grade; the lowest quiz
 * score is dropped.
 *
 * Any grade of 90 or more is an A, any grade of 80 or more (but less than 90) is a B,
 * any grade of 70 or more (but less than 80) is a C, any grade of 60 or more
 * (but less than 70) is a D,and any grade below 60 is an F.
 *
 * The client program should read in the student’s name and scores and output the student’s record,
 * which consists of three quiz scores and two exam scores, as well as the student’s overall numeric
 * score for the entire course and final letter grade.
 *
 * Sample run:
 * Enter student's name:
 * Ada Lovelace
 * Enter the three quiz scores:
 * 90 50 80
 * Enter the midterm score:
 * 70
 * Enter the final exam score:
 * 75
 *
 * StudentRecord created...
 *
 * Student: Ada Lovelace
 * quiz1: 90
 * quiz2: 50
 * quiz3: 80
 * midterm: 70
 * final exam: 75
 * overall grade: 75.25
 * letter grade:  C
 *
 * Define and use a class for the student record. The class should have instance variables for their
 * name, quizzes, midterm, and final exam.
 *
 * The overall numeric score is a decimal number in the range 0 to 100, which represents the weighted
 * average of the student’s work. The class should have methods to compute the overall numeric
 * grade and the final letter grade. Your class should have a toString method that returns
 * a String representation of the StudentRecord object. You may add other methods if you wish.
 *
 * Note: You should have two classes for this program. One class will be
 * called StudentRecord.java to encapsulate the student's record along with any methods
 * that operate on this data. A second class will be the client class,
 * called StudentGrader.java.  The client class will contain the main() method.
 */

public class StudentRecord{

    // instance variables
    private String name;
    private int quiz1;
    private int quiz2;
    private int quiz3;
    private int midterm;
    private int finalExam;

    /**
     * Constructor
     */
    public StudentRecord(String name, int quiz1, int quiz2, int quiz3, int midterm, int finalExam){
        this.name = name;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }


    /**
     * Any grade of 90 or more is an A, any grade of 80 or more (but less than 90) is a B,
     * any grade of 70 or more (but less than 80) is a C, any grade of 60 or more
     * (but less than 70) is a D,and any grade below 60 is an F.
     */
    public char letterGrade(){
        double numericGrade = numericGrade();
        if(numericGrade < 60) {
            return 'F';
        }
        else if(numericGrade < 70) {
            return 'D';
        }
        else if(numericGrade < 80) {
            return 'C';
        }
        else if(numericGrade < 90) {
            return 'B';
        }
        else {
            return 'A';
        }
    }


    /**
     * Setter method for quiz1, quiz2, and quiz3
     */
    public void recordQuizzes(int q1, int q2, int q3){
        quiz1 = q1;
        quiz2 = q2;
        quiz3 = q3;
    }

    /**
     * Setter method for midterm
     */
    public void recordMidterm(int m){
        midterm = m;
    }

    /**
     * Setter method for final exam
     */
    public void recordFinal(int f){
        finalExam = f;
    }


    /**
     *  The grade is 20% quizzes, 35% midterm, and 45% final exam.
     *  The lowest of the three quizzes is dropped, and does not
     *  count toward the final grade.
     *
     */
    public double numericGrade(){
        int lowestQuizScore = Math.min(Math.min(quiz1, quiz2), quiz3);
        double quizzes = (quiz1 + quiz2 + quiz3 - lowestQuizScore) / 2.0;
        return ((quizzes * 0.2) + (midterm * 0.35) + (finalExam * 0.45));
    }

    /**
     * Returns a String representation of a StudentRecord object and should look something
     * similar to this: Remember you can use the newline character in String objects: '\n' or "\n"
     *      Student: Ava Lovelace
     *      quiz1: 90
     *      quiz2: 50
     *      quiz3: 80
     *      midterm: 70
     *      final exam: 75
     *      overall grade: 75.25
     *      letter grade:  C
     */
    public String toString(){
        double numericGrade = numericGrade();
        char letterGrade = letterGrade();
        return "Student: " + name + "\nquiz1: " + quiz1 + "\nquiz2: " + quiz2 + "\nquiz3: " + quiz3 + "\nmidterm: " +
                midterm + "\nfinal exam: " + finalExam + "\noverall grade: "
                + numericGrade + "\nletter grade: " + letterGrade;
    }

}


