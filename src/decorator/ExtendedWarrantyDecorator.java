package decorator;

public class ExtendedWarrantyDecorator implements ProductService {
    private ProductService wrappedService;
    private double warrantyCost;
    private int warrantyMonths;

    public ExtendedWarrantyDecorator(ProductService service, double cost, int months) {
        this.wrappedService = service;
        this.warrantyCost = cost;
        this.warrantyMonths = months;
    }

    public double getCost() {return wrappedService.getCost() + warrantyCost;}

    public String getDescription() {
        return wrappedService.getDescription() + " + Extended Warranty " + warrantyMonths + " months (" + warrantyCost + "₸)";
    }
}
