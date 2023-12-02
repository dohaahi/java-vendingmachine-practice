package vendingmachine.validator;

import vendingmachine.exception.IllegalHeldAmountException;

public class PaymentAmountValidator {
    public static final int MIN_AMOUNT = 100;
    public static final int MAX_AMOUNT = 500_000;
    public static final String INVALID_HELD_AMOUNT_MAX_AMOUNT_MESSAGE = "투입 금액은 10원 이상 50만원 이하입니다. 다시 입력해 주세요.";

    public static void validatePaymentAmount(final String input) {
        InputValidator.validateValueIsEmpty(input);
    }

    public static void validatePaymentAmount(final int amount) {
        validatePaymentInRange(amount);
    }

    private static void validatePaymentInRange(final int amount) {
        if (amount < MIN_AMOUNT || amount > MAX_AMOUNT) {
            throw new IllegalHeldAmountException(INVALID_HELD_AMOUNT_MAX_AMOUNT_MESSAGE);
        }
    }
}