package strategy;

public class PercentDiscount implements DiscountStrategy {
    private final int percent;

    public PercentDiscount(int percent) {
        this.percent = percent;
    }

    @Override
    public double apply(double subtotal) {
        return subtotal - subtotal * percent / 100.0;
    }

    @Override
    public String getDescription() {
        return percent + "% discount";
    }
}
