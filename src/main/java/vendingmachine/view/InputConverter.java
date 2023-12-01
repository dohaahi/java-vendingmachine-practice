package vendingmachine.view;

import vendingmachine.exception.IllegalInputException;

public class InputConverter {
    public static int mapToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalInputException();
        }
    }
}