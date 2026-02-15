public class VehicleMain {
    public static void main(String[] args) {
        Person owner = new Person("Pranav Ananth");

        Vehicle vehicle = new Vehicle("Toyota", 4, owner);
        System.out.println(vehicle);
        vehicle.setCylinders(8);
        System.out.println("\n" + vehicle);

        Truck truck = new Truck("Ford", 4, owner, 8.5, 10);
        System.out.println("\n" + truck);
        owner.setName("William Afton");
        truck.setOwner(owner);
        truck.setLoadCapacity(6);
        System.out.println("\n" + truck);
    }
}