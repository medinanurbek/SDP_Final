package facade;

import strategy.Cart;
import bridge.Payment;
import model.User;

public class CheckoutFacade {
    private final InventoryService inventoryService;
    private final NotificationService notificationService;

    public CheckoutFacade() {
        this.inventoryService = new InventoryService();
        this.notificationService = new NotificationService();
    }

    public boolean checkout(Cart cart, Payment payment, User user) {
        System.out.println("PROCESSING ORDER ");

        if (!inventoryService.reserveItems(cart)) {
            System.out.println("Error: Some items are out of stock.");
            return false;
        }

        double total = cart.getTotal();
        payment.process(total);
        notificationService.sendConfirmation(user, total);

        System.out.println("Order completed successfully!");
        return true;
    }
}
