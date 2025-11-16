package factory;
import model.*;

public class ShopFactory {
    public static Shop createShop(int choice) {
        switch (choice) {
            case 1: return new ZaraStore();
            case 2: return new StradivariusStore();
            case 3: return new BershkaStore();
            default: return null;
        }
    }

    public static Shop recommendShop(User user) {
        if (user.getGender() == Gender.FEMALE && user.getStylePreference() == StylePreference.FEMININE) {
            return new StradivariusStore();
        } else if (user.getStylePreference() == StylePreference.TRENDY && user.getAge() <= 25) {
            return new BershkaStore();
        } else {
            return new ZaraStore();
        }
    }
}
