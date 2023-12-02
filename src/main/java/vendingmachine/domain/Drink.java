package vendingmachine.domain;

import static vendingmachine.validator.DrinkValidator.validateDrinkCount;
import static vendingmachine.validator.DrinkValidator.validateMinDrinkPurchaseAmount;

public class Drink {
    private final String name;
    private final Money purchaseAmount;
    private final int count;
    private int stockCount;

    private Drink(final String name, final Money purchaseAmount, final int count) {
        this.name = name;
        this.purchaseAmount = purchaseAmount;
        this.count = count;
        this.stockCount = count;

        validateMinDrinkPurchaseAmount(purchaseAmount);
        validateDrinkCount(count);
    }

    public static Drink of(final String name, final Money purchaseAmount, final int count) {
        return new Drink(name, purchaseAmount, count);
    }

    public boolean isSame(String drinkName) {
        return name.equals(drinkName);
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getAmount();
    }

    public boolean isEmpty() {
        return stockCount == 0;
    }

    public void purchase() {
        stockCount--;
    }
}