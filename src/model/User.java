package model;

public class User {
    private String username;
    private String password;
    private String email;
    private int age;
    private Gender gender;
    private StylePreference stylePreference;

    public User(String username, String password, String email, int age,
                Gender gender, StylePreference stylePreference) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.stylePreference = stylePreference;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public Gender getGender() { return gender; }
    public StylePreference getStylePreference() { return stylePreference; }
}
