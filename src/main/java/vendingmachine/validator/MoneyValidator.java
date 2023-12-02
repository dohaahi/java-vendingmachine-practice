package vendingmachine.validator;

public class MoneyValidator {
    public static final int MIN_AMOUNT = 10;
    public static final int MONEY_UNIT = 10;
    public static final String INVALID_HELD_AMOUNT_MIN_AMOUNT_MESSAGE = "금액은 10원 이상으로 입력 가능합니다. 다시 입력해 주세요.";
    public static final String INVALID_AMOUNT_UNIT_MESSAGE = "금액은 10원 단위로 입력 가능합니다. 다시 입력해 주세요.";

    public static void validateMoney(final int number) {
        validateHeldAmountInRange(number);
        validateAmountUnit(number);
    }

    private static void validateHeldAmountInRange(final int number) {
        if (number < MIN_AMOUNT) {
            throw new IllegalArgumentException(INVALID_HELD_AMOUNT_MIN_AMOUNT_MESSAGE);
        }
    }

    private static void validateAmountUnit(final int number) {
        if (number % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT_MESSAGE);
        }
    }
}
