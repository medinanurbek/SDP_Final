package facade;

import strategy.Cart;

public class InventoryService {
    public boolean reserveItems(Cart cart) {
        System.out.println("Reserving " + cart.getItems().size() + " items in warehouse...");
        return true;
    }
}