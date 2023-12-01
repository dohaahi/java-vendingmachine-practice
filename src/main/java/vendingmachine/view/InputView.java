package vendingmachine.view;

import static vendingmachine.validator.DrinkValidator.validateInputDrink;
import static vendingmachine.validator.HeldMoneyValidator.validateInputHeldAmount;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import vendingmachine.domain.Drink;
import vendingmachine.domain.Drinks;
import vendingmachine.domain.Money;

public class InputView {
    private static final String HELD_MONEY_AMOUNT_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String DRINK_INPUT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String PAYMENT_AMOUNT_INPUT_MESSAGE = "투입 금액을 입력해 주세요.";

    public static Money readVendingMachineAmount() {
        System.out.println(HELD_MONEY_AMOUNT_INPUT_MESSAGE);
        String input = readLine();
        validateInputHeldAmount(input);

        int amount = InputConverter.mapToInt(input);
        return Money.from(amount);
    }

    public static Drinks readDrinks() {
        System.out.println(DRINK_INPUT_MESSAGE);
        String input = readLine();
        validateInputDrink(input);

        List<Drink> drinks = InputConverter.separatedToTuple(input);
        return Drinks.of(drinks);
    }

    public static Money readPaymentAmount() {
        System.out.println(PAYMENT_AMOUNT_INPUT_MESSAGE);
        String input = readLine();
        validateInputHeldAmount(input);

        int amount = InputConverter.mapToInt(input);
        return Money.from(amount);
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}