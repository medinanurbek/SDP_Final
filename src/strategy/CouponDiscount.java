package strategy;

public class CouponDiscount implements DiscountStrategy {
    private final double amount;

    public CouponDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double apply(double subtotal) {
        double result = subtotal - amount;
        return result < 0 ? 0 : result;
    }

    @Override
    public String getDescription() {
        return "Coupon: -" + amount + "₸";
    }
}
