package factory;
import model.*;
import java.util.List;

public interface Shop {
    String getName();
    String getDescription();
    Gender[] getAvailableGenders();
    StylePreference getStoreStyle();
    List<Product> getProducts();
    boolean isAgeAppropriate(User user);
}