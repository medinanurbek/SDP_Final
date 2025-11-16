package factory;
import model.*;
import java.util.Arrays;
import java.util.List;

public class BershkaStore implements Shop {
    @Override
    public String getName() { return "Bershka"; }

    @Override
    public String getDescription() {
        return "Trendy and bold fashion for young adults";
    }

    @Override
    public Gender[] getAvailableGenders() {
        return new Gender[]{Gender.MALE, Gender.FEMALE};
    }

    @Override
    public StylePreference getStoreStyle() {
        return StylePreference.TRENDY;
    }

    @Override
    public boolean isAgeAppropriate(User user) {
        return user.getAge() >= 14;
    }

    @Override
    public List<Product> getProducts() {
        return Arrays.asList(
                new Product("Oversize Graphic Hoodie", 7999, Category.HOODIES, Gender.UNISEX, StylePreference.TRENDY),
                new Product("Ripped Denim Jeans", 9999, Category.JEANS, Gender.UNISEX, StylePreference.TRENDY),
                new Product("Platform Sneakers", 13999, Category.SNEAKERS, Gender.UNISEX, StylePreference.TRENDY),
                new Product("Denim Jacket", 14999, Category.JACKETS, Gender.UNISEX, StylePreference.TRENDY),
                new Product("Baseball Cap", 2999, Category.HATS, Gender.UNISEX, StylePreference.TRENDY),
                new Product("Cargo Pants", 8499, Category.JEANS, Gender.MALE, StylePreference.TRENDY)
        );
    }
}
