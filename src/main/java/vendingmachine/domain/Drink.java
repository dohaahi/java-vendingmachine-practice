package vendingmachine.domain;

import static vendingmachine.validator.DrinkValidator.validateDrinkCount;
import static vendingmachine.validator.DrinkValidator.validateMinDrinkPurchaseAmount;

public record Drink(
        String name,
        Money purchaseAmount,
        int count
) {
    public Drink {
        validateMinDrinkPurchaseAmount(purchaseAmount);
        validateDrinkCount(count);
    }
}