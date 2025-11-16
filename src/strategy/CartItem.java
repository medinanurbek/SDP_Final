package strategy;

public class CartItem {
    private final String productName;
    private final String size;
    private final int quantity;
    private final double price;

    public CartItem(String productName, String size, int quantity, double price) {
        this.productName = productName;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getProductName() { return productName; }
    public String getSize() { return size; }
}