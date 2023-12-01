package vendingmachine.validator;

import static vendingmachine.validator.MoneyValidator.validateMoney;

import vendingmachine.exception.IllegalHeldAmountException;

public class HeldMoneyValidator {
    public static final int MAX_AMOUNT = 10_000_000;
    public static final String INVALID_HELD_AMOUNT_MAX_AMOUNT_MESSAGE = "보유 금액은 10만원 이하입니다. 다시 입력해 주세요.";

    public static void validateInputHeldAmount(final String input) {
        InputValidator.validateValueIsEmpty(input);
    }

    public static void validateHeldAmount(final int numbers) {
        validateHeldMaxAmount(numbers);
        validateMoney(numbers);
    }

    private static void validateHeldMaxAmount(final int number) {
        if (number > MAX_AMOUNT) {
            throw new IllegalHeldAmountException(INVALID_HELD_AMOUNT_MAX_AMOUNT_MESSAGE);
        }
    }
}