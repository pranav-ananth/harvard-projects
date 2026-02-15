public class StudentDatabaseTester {

    public static void main(String[] args) {

        StudentDatabase db = new StudentDatabase();

        StudentAccount s1 = new StudentAccount(
                "Pranav", "Ananth", "1001", 5, 13, 2009, "DataA");
        StudentAccount s2 = new StudentAccount(
                "Joe", "Smith", "1002", 8, 22, 2006, "DataB");
        StudentAccount s3 = new StudentAccount(
                "John", "Doe", "1003", 1, 5, 2005, "DataC");

        db.addRecord(s1);
        db.addRecord(s2);
        db.addRecord(s3);

        System.out.println("All Accounts");
        db.printAll();

        System.out.println("\nGet by Student ID (1002)");
        System.out.println(db.getByStudentId("1002"));

        System.out.println("\nGet by Composite Key");
        System.out.println(db.getByCompositeKey(s1.getCompositeKey()));

        System.out.println("\nGet by Name \"Smith\"");
        for (StudentAccount s : db.getByName("Smith")) {
            System.out.println(s);
        }

        System.out.println("\nRemove Joe Smith");
        db.removeRecord(s2);
        db.printAll();
    }
}