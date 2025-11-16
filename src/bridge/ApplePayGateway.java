package bridge;

public class ApplePayGateway implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Payment " + amount + " KZT via Apple Pay.");
    }
}
