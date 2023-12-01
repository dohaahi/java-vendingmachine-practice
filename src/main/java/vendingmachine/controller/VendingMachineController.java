package vendingmachine.controller;

import static vendingmachine.util.RetryHandler.retryIfFailure;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Drinks;
import vendingmachine.domain.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public void run() {
        // 1. 보유 동전 입력
        Money amount = retryIfFailure(InputView::readVendingMachineAmount);
        Coins coins = new Coins();
        coins.makeChangeUntilAmountEmpty(amount);
        OutputView.printVendingMachineAmount(coins.toCoinDto());

        Drinks drinks = retryIfFailure(InputView::readDrinks);
        Money paymentAmount = retryIfFailure(InputView::readPaymentAmount);

        // 2. 실행

        // 3. 출력
    }
}
