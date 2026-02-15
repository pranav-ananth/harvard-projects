public class PersonMain {
    public static void main(String[] args) {
        Student student1 = new Student("Pranav", "Ananth", 216692, "OHSC0", "Arpy Khatcharian");
        student1.displayDetails();
        System.out.println();
        Student student2 = new Student("Bob", "Harley", 192404, "JP001", "Edward Robinson");
        student2.displayDetails();
        System.out.println();
        Teacher teacher1 = new Teacher("Arpy", "Khatcharian", "OHSC0", 243000);
        teacher1.displayDetails();
        System.out.println();
        Teacher teacher2 = new Teacher("Edward", "Robinson", "JP001", 252390);
        teacher2.displayDetails();
    }
}
