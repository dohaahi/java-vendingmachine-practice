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
}