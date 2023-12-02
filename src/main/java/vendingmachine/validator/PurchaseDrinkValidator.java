package vendingmachine.validator;

import java.util.regex.Pattern;
import vendingmachine.domain.VendingMachine;
import vendingmachine.exception.IllegalPurchaseDrinkException;

public class PurchaseDrinkValidator {
    private static final String PURCHASE_DRINK_REGEX = "^[가-힣]*$";
    private static final String INVALID_VENDING_MACHINE_HAVE_NOT_DRINK_MESSAGE = "자판기에 존재히지 않는 상품입니다. 다시 입력헤 주세요.";

    public static void validateInputPurchaseDrink(final String input) {
        InputValidator.validateValueIsEmpty(input);
        validatePurchaseDrinkPatternInput(input);
    }

    public static void validatePurchaseDrink(final VendingMachine vendingMachine, final String drinkName) {
        validateVendingMachineHasDrink(vendingMachine, drinkName);
    }

    private static void validatePurchaseDrinkPatternInput(final String input) {
        if (!Pattern.matches(PURCHASE_DRINK_REGEX, input)) {
            throw new IllegalPurchaseDrinkException();
        }
    }

    private static void validateVendingMachineHasDrink(final VendingMachine vendingMachine, final String drinkName) {
        if (!vendingMachine.hasDrink(drinkName)) {
            throw new IllegalPurchaseDrinkException(INVALID_VENDING_MACHINE_HAVE_NOT_DRINK_MESSAGE);
        }
    }
}