public class Truck extends Vehicle {
    private double loadCapacity;
    private int towingCapacity;

    // Constructor
    public Truck(String name, int cylinders, Person owner, double loadCapacity, int towingCapacity) {
        super(name, cylinders, owner);
        this.loadCapacity = loadCapacity;
        this.towingCapacity = towingCapacity;
    }

    // Accessors
    public double getLoadCapacity() {
        return loadCapacity;
    }
    public int getTowingCapacity() {
        return towingCapacity;
    }

    // Mutators
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public void setTowingCapacity(int towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nNumber of Cylinders: " + getCylinders() + "\nOwner: " + getOwner().getName()
                + "\nLoad Capacity: " + getLoadCapacity() + "\nTowing Capacity: " + getTowingCapacity();
    }

    public boolean equals(Truck other) {
        if(other.getName().equals(getName()) && other.getCylinders() == getCylinders()
                && other.getOwner().equals(getOwner()) && other.getLoadCapacity() == getLoadCapacity()
                && other.getTowingCapacity() == getTowingCapacity()) {
            return true;
        }
        return false;
    }
}
