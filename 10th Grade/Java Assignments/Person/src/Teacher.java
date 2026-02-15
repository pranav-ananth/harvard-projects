public class Teacher extends Person {
    private String subjectName;
    private int salary;

    public Teacher(String firstName, String lastName, String subjectName, int salary) {
        super(firstName, lastName);
        this.subjectName = subjectName;
        this.salary = salary;
    }

    /**
     Prints the details of the teacher.
     **/
    public void displayDetails() {
        System.out.println(this);
    }

    /**
     Returns a string representation of all the information of the teacher in the following format:
     Name:
     Subject:
     Salary:
     **/
    @Override
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName() + "\nSubject: " + subjectName + "\nSalary: $" + salary;
    }
}