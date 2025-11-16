package bridge;

public class OnlinePayment extends Payment {
    public OnlinePayment(PaymentGateway gateway) {
        super(gateway);
    }

    @Override
    public void process(double amount) {
        System.out.println("Preparing online payment...");
        gateway.pay(amount);
        System.out.println("The transaction is complete.");
    }
}
