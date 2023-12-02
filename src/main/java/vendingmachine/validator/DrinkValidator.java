package vendingmachine.validator;

import java.util.regex.Pattern;
import vendingmachine.domain.Money;
import vendingmachine.exception.IllegalDrinkException;

public class DrinkValidator {
    public static final int MIN_PURCHASE_AMOUNT_NUMBER = 100;
    public static final int MAX_DRINK_COUNT = 50;
    private static final String DRINK_REGEX = "^[\\[가-힣]+,[\\d]+,[\\d]+]+(;[\\[가-힣]+,[\\d]+,[\\d]+]+)*$";
    private static final String INVALID_DRINK_COUNT = "상품 가능 최대 개수는 50개 이하입니다. 다시 입력해 주세요.";

    public static void validateInputDrink(final String input) {
        InputValidator.validateValueIsEmpty(input);
        validateDrinkPatternInput(input);
    }

    public static void validateMinDrinkPurchaseAmount(final Money purchaseAmount) {
        if (purchaseAmount.getAmount() < MIN_PURCHASE_AMOUNT_NUMBER) {
            throw new IllegalDrinkException();
        }
    }

    public static void validateDrinkCount(final int count) {
        if (count > MAX_DRINK_COUNT) {
            throw new IllegalArgumentException(INVALID_DRINK_COUNT);
        }
    }

    private static void validateDrinkPatternInput(final String input) {
        if (!Pattern.matches(DRINK_REGEX, input)) {
            throw new IllegalDrinkException();
        }
    }
}