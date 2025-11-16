package decorator;

public class BaseProductService implements ProductService {
    private double productPrice;
    private String productName;

    public BaseProductService(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public double getCost() { return productPrice;}
    public String getDescription() { return productName;}
}
