package ua.opnu;

public class GroceryBill {
    private Employee clerk;
    private double total;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.total = 0.0;
    }

    public void add(Item i) {
        this.total += i.getPrice();
    }

    public double getTotal() {
        return this.total;
    }

    public Employee getClerk() {
        return clerk;
    }
}
