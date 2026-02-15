public class Person {
    private String firstName;
    private String lastName;

    // constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // accessors
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // mutators
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     Prints the name of the person.
     **/
    public void displayDetails() {
        System.out.println(this);
    }

    /**
     Returns a string representation of the name of the person.
     **/
    @Override
    public String toString() {
        return "Full name: " + firstName + " " + lastName;
    }

    /**
        This function compares the first and last names of two Person objects, and returns true if they are the same.
        @param otherPerson
        @return true if the first and last names of both Person objects are the same, and false otherwise
     **/
    @Override
    public boolean equals(Object otherPerson) {
        if(otherPerson == null || this.getClass() != otherPerson.getClass())
            return false;
        else {
            Person p = (Person) otherPerson;
            if(this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName)) {
                return true;
            }
            return false;
        }
    }
}