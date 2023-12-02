package vendingmachine.controller;

import static vendingmachine.util.RetryHandler.retryIfFailure;

import vendingmachine.domain.PurchaseDrink;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.VendingMachineStatus;
import vendingmachine.view.InputView;

public class VendingMachineController {

    public void run() {
        // 1. 자판기 생성
        VendingMachine vendingMachine = InputView.makeVendingMachine();

        // 2. 상품 구매
        purchaseDrink(vendingMachine);

        // 3. 출력
    }

    private void purchaseDrink(final VendingMachine vendingMachine) {
        VendingMachineStatus status = VendingMachineStatus.AVAILABLE_PURCHASE;

        while (status.equals(VendingMachineStatus.AVAILABLE_PURCHASE)) {
            PurchaseDrink purchaseDrink = retryIfFailure(() -> InputView.readPurchaseDrink(vendingMachine));
            status = vendingMachine.purchase(purchaseDrink);
        }
    }
}