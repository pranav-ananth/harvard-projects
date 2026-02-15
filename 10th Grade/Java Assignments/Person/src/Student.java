public class Student extends Person {
    private int studentID;
    private String course;
    private String teacherName;

    public Student(String firstName, String lastName, int studentID, String course, String teacherName) {
        super(firstName, lastName);
        this.studentID = studentID;
        this.course = course;
        this.teacherName = teacherName;
    }

    /**
     Prints the details of the student.
     **/
    public void displayDetails() {
        System.out.println(this);
    }

    /**
     Returns a string representation of all the information of the student in the following format:
     Name:
     Student ID:
     Course:
     Teacher:
     **/
    @Override
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName() + "\nStudent ID: " + studentID + "\nCourse: " + course + "\nTeacher: " + teacherName;
    }
}