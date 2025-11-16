package factory;
import model.*;
import java.util.Arrays;
import java.util.List;

public class ZaraStore implements Shop {
    @Override
    public String getName() { return "Zara"; }

    @Override
    public String getDescription() {
        return "Classic and sophisticated fashion for all ages";
    }

    @Override
    public Gender[] getAvailableGenders() {
        return new Gender[]{Gender.MALE, Gender.FEMALE, Gender.KIDS};
    }

    @Override
    public StylePreference getStoreStyle() {
        return StylePreference.CLASSIC;
    }

    @Override
    public boolean isAgeAppropriate(User user) {
        return true; // Все возрасты
    }

    @Override
    public List<Product> getProducts() {
        return Arrays.asList(
                new Product("Wool Blend Coat", 29999, Category.COATS, Gender.UNISEX, StylePreference.CLASSIC),
                new Product("Cashmere Sweater", 17999, Category.SWEATERS, Gender.UNISEX, StylePreference.CLASSIC),
                new Product("Classic Leather Shoes", 22999, Category.SHOES, Gender.MALE, StylePreference.CLASSIC),
                new Product("Trench Coat", 25999, Category.COATS, Gender.FEMALE, StylePreference.CLASSIC),
                new Product("Kids Winter Jacket", 12999, Category.KIDS_CLOTHING, Gender.KIDS, StylePreference.CLASSIC),
                new Product("Leather Handbag", 18999, Category.BAGS, Gender.FEMALE, StylePreference.CLASSIC)
        );
    }
}