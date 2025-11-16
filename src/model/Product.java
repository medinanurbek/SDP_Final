package model;

public class Product {
    private final String name;
    private final double price;
    private final Category category;
    private final Gender gender;
    private final StylePreference style;

    public Product(String name, double price, Category category, Gender gender, StylePreference style) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.gender = gender;
        this.style = style;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public Category getCategory() { return category; }
    public Gender getGender() { return gender; }
    public StylePreference getStyle() { return style; }
}
