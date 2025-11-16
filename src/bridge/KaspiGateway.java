package bridge;

public class KaspiGateway implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Payment " + amount + " KZT via Kaspi.");
    }
}