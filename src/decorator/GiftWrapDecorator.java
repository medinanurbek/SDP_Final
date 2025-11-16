package decorator;

public class GiftWrapDecorator implements ProductService {
    private ProductService wrappedService;
    private double wrapCost;

    public GiftWrapDecorator(ProductService service, double cost) {
        this.wrappedService = service;
        this.wrapCost = cost;
    }

    public double getCost() {return wrappedService.getCost() + wrapCost;}

    public String getDescription() {
        return wrappedService.getDescription() + " + Gift Wrap (" + wrapCost + "₸)";
    }
}
