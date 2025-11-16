package strategy;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double apply(double subtotal) {
        return subtotal;
    }

    @Override
    public String getDescription() {
        return "No discount";
    }
}