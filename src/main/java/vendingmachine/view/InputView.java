package vendingmachine.view;

import static vendingmachine.validator.HeldMoneyValidator.validateInputHeldAmount;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String HELD_MONEY_AMOUNT_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.;";

    public static int readVendingMachineAmount() {
        System.out.println(HELD_MONEY_AMOUNT_INPUT_MESSAGE);
        String input = readLine();
        validateInputHeldAmount(input);

        return InputConverter.mapToInt(input);
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}