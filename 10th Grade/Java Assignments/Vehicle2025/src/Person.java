public class Person {
    private String name;

    // Constructor
    public Person(String name) {
        this.name = name;
    }

    // Accessor
    public String getName() {
        return name;
    }

    // Mutator
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + getName();
    }

    public boolean equals(Person other) {
        if(other.name.equals(getName())){
            return true;
        }
        return false;
    }
}
