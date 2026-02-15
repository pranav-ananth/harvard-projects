public class Vehicle {
    private String name;
    private int cylinders;
    private Person owner;

    // Constructor
    public Vehicle(String name, int cylinders, Person owner) {
        this.name = name;
        this.cylinders = cylinders;
        this.owner = owner;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public Person getOwner() {
        return owner;
    }

    // Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nNumber of Cylinders: " + getCylinders() + "\nOwner: " + owner.getName();
    }

    @Override
    public boolean equals(Object other) {
        if(other.getName().equals(getName()) && other.cylinders == getCylinders() && other.owner.equals(getOwner())) {
            return true;
        }
        return false;
    }
}
