package vendingmachine.validator;


import vendingmachine.exception.IllegalHeldAmountException;

public class HeldMoneyValidator {
    public static final int MAX_AMOUNT = 100_000;
    public static final String INVALID_HELD_AMOUNT_MAX_AMOUNT_MESSAGE = "보유 금액은 10만원 이하입니다. 다시 입력해 주세요.";

    public static void validateInputHeldAmount(final String input) {
        InputValidator.validateValueIsEmpty(input);
    }

    public static void validateHeldAmount(final int amount) {
        validateHeldMaxAmount(amount);
    }

    private static void validateHeldMaxAmount(final int amount) {
        if (amount > MAX_AMOUNT) {
            throw new IllegalHeldAmountException(INVALID_HELD_AMOUNT_MAX_AMOUNT_MESSAGE);
        }
    }
}