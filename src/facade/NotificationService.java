package facade;

import model.User;

public class NotificationService {
    public void sendConfirmation(User user, double total) {
        System.out.println("Sent confirmation email to " + user.getEmail());
        System.out.println("Order total: " + total + "₸");
    }
}