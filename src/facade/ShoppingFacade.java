package facade;

import model.*;
import factory.*;
import strategy.*;
import bridge.*;
import observer.*;
import java.util.List;
import java.util.Scanner;

public class ShoppingFacade {
    private User currentUser;
    private Shop selectedShop;
    private Cart cart;
    private CartObserver cartObserver;

    public ShoppingFacade() {
        this.cart = new Cart();
        this.cartObserver = new CartObserver("Cart Monitor");
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
        System.out.println("Welcome, " + user.getUsername() + "!");
        System.out.println("Your style: " + user.getStylePreference());
        System.out.println("Your gender: " + user.getGender());
        System.out.println("Your age: " + user.getAge());
    }

    public void recommendAndSelectShop() {
        if (currentUser == null) {
            System.out.println("Please login first!");
            return;
        }

        Shop recommendedShop = ShopFactory.recommendShop(currentUser);
        System.out.println("RECOMMENDED STORE FOR YOU:");
        System.out.println(recommendedShop.getName());
        System.out.println(recommendedShop.getDescription());
        System.out.println(recommendedShop.getStoreStyle());

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDo you want to shop at " + recommendedShop.getName() + "? (y/n): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            selectedShop = recommendedShop;
        }
        else {
            showShopSelection();
        }

        if (!selectedShop.isAgeAppropriate(currentUser)) {
            System.out.println("Sorry, this store is not age-appropriate for you!");
            selectedShop = ShopFactory.recommendShop(currentUser);
        }

        System.out.println("Selected store: " + selectedShop.getName());
    }

    private void showShopSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n AVAILABLE STORES:");
        System.out.println("1. Zara - Classic fashion for all ages");
        System.out.println("2. Stradivarius - Feminine elegance for women");
        System.out.println("3. Bershka - Trendy fashion for young adults");

        System.out.print("Choose store (1-3): ");
        int choice = scanner.nextInt();
        selectedShop = ShopFactory.createShop(choice);

        if (selectedShop == null) {
            System.out.println("Invalid store selection!");
            showShopSelection();
        }
    }

    public void browseProducts() {
        if (selectedShop == null) {
            System.out.println(" Please select a store first!");
            return;
        }

        List<Product> products = selectedShop.getProducts();
        System.out.println("\nAVAILABLE PRODUCTS at " + selectedShop.getName() + ":");
        System.out.println("-----------------------------------");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - " + product.getPrice() + "₸");
            System.out.println("   Category: " + product.getCategory() + " | Style: " + product.getStyle());
            System.out.println("   Gender: " + product.getGender());
            System.out.println();
        }
    }

    public void addProductToCart(int productIndex, String size, String color) {
        if (selectedShop == null) {
            System.out.println("Please select a store first!");
            return;
        }

        List<Product> products = selectedShop.getProducts();
        if (productIndex < 1 || productIndex > products.size()) {
            System.out.println("Invalid product selection!");
            return;
        }

        Product product = products.get(productIndex - 1);
        CartItem item = new CartItem(product.getName(), size, 1, product.getPrice());
        cart.addItem(item);

        cartObserver.update("Added to cart: " + product.getName() + " [" + size + ", " + color + "]");
        System.out.println("Product added to cart!");
    }

    public void applyDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAVAILABLE DISCOUNTS:");
        System.out.println("1. No discount");
        System.out.println("2. 10% Seasonal discount");
        System.out.println("3. 15% Student discount");
        System.out.println("4. 2000₸ Fixed discount");
        System.out.println("5. Style-based discount (12% for your style)");

        System.out.print("Choose discount (1-5): ");
        int choice = scanner.nextInt();

        DiscountStrategy discount = switch (choice) {
            case 2 -> new PercentDiscount(10);
            case 3 -> new PercentDiscount(15);
            case 4 -> new CouponDiscount(2000);
            case 5 -> new PercentDiscount(12);
            default -> new NoDiscount();
        };

        cart.setDiscountStrategy(discount);
        cartObserver.update("Discount applied: " + discount.getDescription());
        System.out.println("Applied: " + discount.getDescription());
    }

    public void viewCart() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        }

        System.out.println("\nYOUR SHOPPING CART:");
        for (int i = 0; i < cart.getItems().size(); i++) {
            CartItem item = cart.getItems().get(i);
            System.out.println((i + 1) + ". " + item.getProductName() +
                    " [" + item.getSize() + "] x" + item.getQuantity() +
                    " - " + item.getPrice() + "₸");
        }
        System.out.println("Subtotal: " + cart.getSubtotal() + "₸");
        System.out.println("Discount: " + getCurrentDiscountDescription());
        System.out.println("Total: " + cart.getTotal() + "₸");
        System.out.println("----------------------------\n");
    }

    private String getCurrentDiscountDescription() {
        if (cart.getTotal() == cart.getSubtotal()) {
            return "No discount";
        }
        return "Applied (" + (cart.getSubtotal() - cart.getTotal()) + "₸ saved)";
    }

    public void checkout() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        viewCart();

        Scanner scanner = new Scanner(System.in);
        System.out.println("SELECT PAYMENT METHOD:");
        System.out.println("1. Kaspi Bank");
        System.out.println("2. Halyk Bank");
        System.out.println("3. Apple Pay");

        System.out.print("Choose payment method (1-3): ");
        int paymentChoice = scanner.nextInt();

        PaymentGateway gateway = switch (paymentChoice) {
            case 2 -> new HalykBankGateway();
            case 3 -> new ApplePayGateway();
            default -> new KaspiGateway();
        };

        Payment payment = new OnlinePayment(gateway);

        CheckoutFacade checkout = new CheckoutFacade();
        boolean success = checkout.checkout(cart, payment, currentUser);

        if (success) {
            cartObserver.update("Order completed successfully! Total: " + cart.getTotal() + "₸");
            cart.clear();
        }
    }
}