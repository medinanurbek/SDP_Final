package bridge;

public class HalykBankGateway implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Payment " + amount + " KZT via HalykBank.");
    }
}