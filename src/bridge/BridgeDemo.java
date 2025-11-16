package bridge;

import java.util.Scanner;

public class BridgeDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double amount = 55990;

        System.out.println("Amount to pay: " + amount + " KZT");
        System.out.println("Select payment method:");
        System.out.println("1. Kaspi");
        System.out.println("2. Halyk Bank");
        System.out.println("3. Apple Pay");

        String choice = in.nextLine();

        PaymentGateway gateway = switch (choice) {
            case "2" -> new HalykBankGateway();
            case "3" -> new ApplePayGateway();
            default -> new KaspiGateway();
        };

        Payment payment = new OnlinePayment(gateway);
        payment.process(amount);
    }
}