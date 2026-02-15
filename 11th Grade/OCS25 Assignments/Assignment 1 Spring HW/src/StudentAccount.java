import java.util.*;

public class StudentAccount {

    private String firstName;
    private String lastName;
    private String studentId;
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private String data;

    public StudentAccount(String firstName, String lastName, String studentId,
                          int birthMonth, int birthDay, int birthYear, String data) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
        this.data = data;
    }

    public String getStudentId() {return studentId;}

    public String getCompositeKey() {
        return birthYear + "-" + birthMonth + "-" + birthDay + "-" +
                firstName.toLowerCase() + "-" + lastName.toLowerCase();
    }

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public void setData(String data) {this.data = data;}

    @Override
    public String toString() {
        return "StudentAccount: " +
                "ID = " + studentId + ", Name = " + firstName + " " + lastName +
                ", DOB = " + birthMonth + "/" + birthDay + "/" + birthYear +
                ", Data = " + data;
    }
}