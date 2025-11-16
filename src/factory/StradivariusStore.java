package factory;
import model.*;
import java.util.Arrays;
import java.util.List;

public class StradivariusStore implements Shop {
    @Override
    public String getName() { return "Stradivarius"; }

    @Override
    public String getDescription() {
        return "Feminine and elegant fashion for modern women";
    }

    @Override
    public Gender[] getAvailableGenders() {
        return new Gender[]{Gender.FEMALE};
    }

    @Override
    public StylePreference getStoreStyle() {
        return StylePreference.FEMININE;
    }

    @Override
    public boolean isAgeAppropriate(User user) {
        return user.getAge() >= 16;
    }

    @Override
    public List<Product> getProducts() {
        return Arrays.asList(
                new Product("Floral Summer Dress", 12999, Category.DRESSES, Gender.FEMALE, StylePreference.FEMININE),
                new Product("Elegant Heels", 15999, Category.HEELS, Gender.FEMALE, StylePreference.FEMININE),
                new Product("Leather Crossbody Bag", 8999, Category.BAGS, Gender.FEMALE, StylePreference.FEMININE),
                new Product("Silk Blouse", 11999, Category.BLOUSES, Gender.FEMALE, StylePreference.FEMININE),
                new Product("Pearl Necklace", 4999, Category.JEWELRY, Gender.FEMALE, StylePreference.FEMININE)
        );
    }
}