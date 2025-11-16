package strategy;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();
    private DiscountStrategy discountStrategy = new NoDiscount();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        if (discountStrategy != null) {
            this.discountStrategy = discountStrategy;
        }
    }

    public double getSubtotal() {
        double sum = 0;
        for (CartItem item : items) {
            sum += item.getPrice() * item.getQuantity();
        }
        return sum;
    }

    public double getTotal() {
        return discountStrategy.apply(getSubtotal());
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public void clear() {
        items.clear();
    }
}