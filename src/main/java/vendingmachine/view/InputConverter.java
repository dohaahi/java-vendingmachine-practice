package vendingmachine.view;

import java.util.Arrays;
import java.util.List;
import vendingmachine.domain.Drink;
import vendingmachine.domain.Money;
import vendingmachine.exception.IllegalInputException;

public class InputConverter {
    public static int mapToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalInputException();
        }
    }

    public static List<Drink> separatedToTuple(final String input) {
        final String[] separatedBySemicolon = input
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .split(";");

        return Arrays.stream(separatedBySemicolon)
                .map(str -> {
                    String[] values = str.split(",");
                    return Drink.of(
                            values[0],
                            Money.from(Integer.parseInt(values[1])),
                            Integer.parseInt(values[2])
                    );
                })
                .toList();
    }
}