public class Cruise {
    private int signups;
    private int price;

    public Cruise(int signups, int price) {
        this.signups = signups;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void checkResponse(String response) {
        if(response.contains("cruise")) {
            signups++;
        }
    }


    public int calculateRevenue() {
        return signups * price;
    }
}