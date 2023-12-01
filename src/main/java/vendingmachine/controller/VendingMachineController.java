package vendingmachine.controller;

import vendingmachine.domain.Drinks;
import vendingmachine.domain.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public void run() {
        // 1. 입력
        Money amount = InputView.readVendingMachineAmount();
        OutputView.printVendingMachineAmount(amount.toMoneyDto());

        Drinks drinks = InputView.readDrinks();
        Money paymentAmount = InputView.readPaymentAmount();

        // 2. 실행

        // 3. 출력
    }
}
