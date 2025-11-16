package auth;
import model.*;
import java.util.HashMap;

public class AuthService {
    private HashMap<String, User> users = new HashMap<>();

    public User register(String username, String password, String email, int age,
                         Gender gender, StylePreference style) {
        if (users.containsKey(username)) {
            System.out.println("User already exists!");
            return null;
        }
        User user = new User(username, password, email, age, gender, style);
        users.put(username, user);
        System.out.println("Registration successful!");
        return user;
    }

    public User login(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("User not found!");
            return null;
        }
        User user = users.get(username);
        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid password!");
            return null;
        }
        System.out.println("Login successful!");
        return user;
    }
}
