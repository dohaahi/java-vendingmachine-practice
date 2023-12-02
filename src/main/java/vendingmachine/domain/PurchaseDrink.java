package vendingmachine.domain;

import static vendingmachine.validator.PurchaseDrinkValidator.validatePurchaseDrink;

public class PurchaseDrink {
    private final String name;

    public PurchaseDrink(final VendingMachine vendingMachine, final String name) {
        validatePurchaseDrink(vendingMachine, name);
        this.name = name;
    }

    public static PurchaseDrink from(final VendingMachine vendingMachine, final String name) {
        return new PurchaseDrink(vendingMachine, name);
    }

    public String getName() {
        return name;
    }
}
