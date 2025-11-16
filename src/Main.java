import facade.ShoppingFacade;
import auth.AuthService;
import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        ShoppingFacade shoppingFacade = new ShoppingFacade();

        System.out.println("\n WELCOME TO FASHION E-COMMERCE");

        // Authentification
        User currentUser = authenticateUser(authService, scanner);
        if (currentUser == null) return;

        shoppingFacade.setCurrentUser(currentUser);

        // Recommendations
        shoppingFacade.recommendAndSelectShop();

        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    shoppingFacade.browseProducts();
                    break;

                case 2:
                    shoppingFacade.browseProducts();
                    System.out.print("Enter product number to add to cart: ");
                    int productNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter size: ");
                    String size = scanner.nextLine();
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    shoppingFacade.addProductToCart(productNum, size, color);
                    break;

                case 3:
                    shoppingFacade.viewCart();
                    break;

                case 4:
                    shoppingFacade.applyDiscount();
                    break;

                case 5:
                    shoppingFacade.checkout();
                    break;

                case 6:
                    System.out.println("Thank you for shopping with us!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    private static User authenticateUser(AuthService authService, Scanner scanner) {
        System.out.println("\n AUTHENTICATION");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Choose option (1-2): ");

        int authChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (authChoice == 1) {
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Gender: 1. Male, 2. Female, 3. Unisex");
            int genderChoice = scanner.nextInt();
            scanner.nextLine();
            Gender gender = switch (genderChoice) {
                case 1 -> Gender.MALE;
                case 2 -> Gender.FEMALE;
                default -> Gender.UNISEX;
            };

            System.out.println("Style Preference: 1. Classic, 2. Trendy, 3. Feminine, 4. Sporty");
            int styleChoice = scanner.nextInt();
            scanner.nextLine();
            StylePreference style = switch (styleChoice) {
                case 1 -> StylePreference.CLASSIC;
                case 2 -> StylePreference.TRENDY;
                case 3 -> StylePreference.FEMININE;
                default -> StylePreference.SPORTY;
            };

            return authService.register(username, password, email, age, gender, style);
        } else {
            return authService.login(username, password);
        }
    }

    private static void showMainMenu() {
        System.out.println("\n MAIN MENU");
        System.out.println("1. Browse Products");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Apply Discount");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.print("Choose option (1-6): ");
    }
}
