package ua.opnu;

public class DiscountBill extends GroceryBill {
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double discountedTotal;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountedTotal = 0.0;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        double itemPrice = i.getPrice();
        double itemDiscount = 0.0;
        if (this.regularCustomer) {
            itemDiscount = i.getDiscount();
        }
        this.discountedTotal += (itemPrice - itemDiscount);
        if (this.regularCustomer && itemDiscount > 0.0) {
            this.discountCount++;
            this.discountAmount += itemDiscount;
        }
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public double getTotal() {
        return Math.round(this.discountedTotal * 100.0) / 100.0;
    }

    public double getDiscountPercent() {
        double fullPrice = super.getTotal();
        double discountedPrice = this.getTotal();
        if (fullPrice == 0.0) {
            return 0.0;
        }
        double discount = 100.0 - (discountedPrice * 100.0) / fullPrice;
        return Math.round(discount * 1e13) / 1e13;
    }
}