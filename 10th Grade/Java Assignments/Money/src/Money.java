public class Money {
    private int dollars;
    private int cents;

    // Constructors
    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money(int dollars) {
        this.dollars = dollars;
        this.cents = 0;
    }

    public Money() {
        this.dollars = 5;
        this.cents = 99;
    }

    // Accessors
    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    // Mutators
    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    public double add(int dollars, int cents) {
        return (this.dollars + 0.01 * this.cents) + (dollars + 0.01 * cents);
    }

    public double subtract(int dollars, int cents) {
        return (this.dollars + (0.01 * this.cents)) - (dollars + (0.01 * cents));
    }

    // Adds the values of two Money objects.
    public double add(Object other1) {
        Money other = (Money) other1;
        return (dollars + 0.01 * cents) + (other.getDollars() + 0.01 * other.getCents());
    }

    // Subtracts the values of two Money objects.
    public double subtract(Money other1) {
        final Money other = (Money) other1;
        return (dollars + (0.01 * cents)) - (other.getDollars() + (0.01 * other.getCents()));
    }

    @Override
    public String toString() {
        return "Cost: " + dollars + "." + cents;
    }

    @Override
    public boolean equals(Object other1) {
        final Money other = (Money) other1;

        if(dollars == other.getDollars() && cents == other.getCents()) {
            return true;
        }
        return false;
    }
}
