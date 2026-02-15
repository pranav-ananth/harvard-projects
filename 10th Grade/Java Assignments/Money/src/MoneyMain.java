public class MoneyMain {
    public static void main(String[] args) {
        Money pen = new Money(0, 99);
        Money bottle = new Money(4, 99);

        pen.setDollars(5);
        System.out.println(pen + "\n" + bottle);
        System.out.println("Discounted Cost: " + pen.subtract(0, 40));
        System.out.println("Total Cost: " + pen.add(bottle));
    }
}
