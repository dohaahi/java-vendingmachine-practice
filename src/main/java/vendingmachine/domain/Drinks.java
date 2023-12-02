package vendingmachine.domain;

import java.util.List;

public class Drinks {
    private final List<Drink> drinks;

    private Drinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public static Drinks of(final List<Drink> drinks) {
        return new Drinks(drinks);
    }

    public boolean hasDrink(final String drinkName) {
        return drinks.stream()
                .anyMatch(drink -> drink.isSame(drinkName));
    }

    public int getPurchaseAmount(final String name) {
        return drinks.stream()
                .filter(drink -> drink.isSame(name))
                .mapToInt(Drink::getPurchaseAmount)
                .sum();
    }

    public int getMinPurchaseAmount() {
        return drinks.stream()
                .mapToInt(Drink::getPurchaseAmount)
                .min()
                .orElse(0);
    }

    public boolean isEmptyAll() {
        return drinks.stream()
                .allMatch(Drink::isEmpty);
    }

    public void canPurchase(final PurchaseDrink purchaseDrink) {
        drinks.forEach(drink -> {
                    if (drink.isSame(purchaseDrink.getName())) {
                        drink.purchase();
                    }
                }
        );
    }
}