package vendingmachine.view;

import static vendingmachine.util.RetryHandler.retryIfFailure;
import static vendingmachine.validator.DrinkValidator.validateInputDrink;
import static vendingmachine.validator.HeldMoneyValidator.validateInputHeldAmount;
import static vendingmachine.validator.PurchaseDrinkValidator.validateInputPurchaseDrink;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Drink;
import vendingmachine.domain.Drinks;
import vendingmachine.domain.Money;
import vendingmachine.domain.PurchaseDrink;
import vendingmachine.domain.VendingMachine;

public class InputView {
    private static final String HELD_MONEY_AMOUNT_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String DRINK_INPUT_MESSAGE = System.lineSeparator() + "상품명과 가격, 수량을 입력해 주세요.";
    private static final String PAYMENT_AMOUNT_INPUT_MESSAGE = System.lineSeparator() + "투입 금액을 입력해 주세요.";
    private static final String PURCHASE_DRINK_INPUT_MESSAGE = System.lineSeparator() +
            """
                    투입 금액: %d원
                    구매할 상품명을 입력해 주세요.
                    """.stripIndent();

    public static VendingMachine makeVendingMachine() {
        final Coins coins = retryIfFailure(InputView::readVendingMachineAmount);
        OutputView.printVendingMachineAmount(coins.toCoinDto());

        final Drinks drinks = retryIfFailure(InputView::readDrinks);
        final Money paymentAmount = retryIfFailure(InputView::readPaymentAmount);

        return VendingMachine.of(coins, drinks, paymentAmount);
    }

    public static PurchaseDrink readPurchaseDrink(final VendingMachine vendingMachine) {
        System.out.printf(PURCHASE_DRINK_INPUT_MESSAGE, vendingMachine.getPaymentAmount());
        final String input = readLine();
        validateInputPurchaseDrink(input);

        return PurchaseDrink.from(vendingMachine, input);
    }

    private static Coins readVendingMachineAmount() {
        System.out.println(HELD_MONEY_AMOUNT_INPUT_MESSAGE);
        final String input = readLine();
        validateInputHeldAmount(input);

        final int amount = InputConverter.mapToInt(input);
        return Coins.from(amount);
    }

    private static Drinks readDrinks() {
        System.out.println(DRINK_INPUT_MESSAGE);
        final String input = readLine();
        validateInputDrink(input);

        final List<Drink> drinks = InputConverter.separatedToTuple(input);
        return Drinks.of(drinks);
    }

    private static Money readPaymentAmount() {
        System.out.println(PAYMENT_AMOUNT_INPUT_MESSAGE);
        final String input = readLine();
        validateInputHeldAmount(input);

        final int amount = InputConverter.mapToInt(input);
        return Money.from(amount);
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}