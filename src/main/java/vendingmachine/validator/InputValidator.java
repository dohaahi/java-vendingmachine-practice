package vendingmachine.validator;

import vendingmachine.exception.IllegalInputException;

public class InputValidator {
    private static final String INPUT_VALUE_MESSAGE = "값을 입력해주세요.";

    public static void validateValueIsEmpty(final String input) {
        if (input.isBlank()) {
            throw new IllegalInputException(INPUT_VALUE_MESSAGE);
        }
    }
}