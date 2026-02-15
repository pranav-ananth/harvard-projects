import java.util.Collection;
import java.util.Arrays;

class InventoryItem implements Comparable<InventoryItem> {
    private String name;
    private int uniqueItemID;

    public InventoryItem(String name, int uniqueItemID) {
        this.name = name;
        this.uniqueItemID = uniqueItemID;
    }

    public String getName() {
        return name;
    }
    public int getUniqueItemID() {
        return uniqueItemID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setUniqueItemID(int uniqueItemID) {
        this.uniqueItemID = uniqueItemID;
    }

    @Override
    public int compareTo(InventoryItem other) {
        return Integer.compare(this.uniqueItemID, other.uniqueItemID);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + uniqueItemID;
    }

    public static void main(String[] args) {
        InventoryItem[] inventory = {
                new InventoryItem("Laptop", 101),
                new InventoryItem("Mouse", 52),
                new InventoryItem("Keyboard", 38),
                new InventoryItem("Monitor", 195)
        };

        Arrays.sort(inventory);

        System.out.println("Sorted Inventory Items:");
        for (InventoryItem item : inventory) {
            System.out.println(item);
        }
    }
}

