package vendingmachine.domain;

import vendingmachine.domain.dto.VendingMachineCoinDto;

public class VendingMachine {
    private final Coins coins;
    private final Drinks drinks;
    private final Money paymentAmount;
    private int balance;


    private VendingMachine(final Coins coins, final Drinks drinks, final Money paymentAmount) {
        this.coins = coins;
        this.drinks = drinks;
        this.paymentAmount = paymentAmount;
        this.balance = paymentAmount.getAmount();
    }

    public static VendingMachine of(final Coins coins, final Drinks drinks, final Money paymentAmount) {
        return new VendingMachine(coins, drinks, paymentAmount);
    }

    public boolean hasDrink(final String drinkName) {
        return drinks.hasDrink(drinkName);
    }

    public VendingMachineCoinDto getCoinDto() {
        return coins.toCoinDto();
    }

    public int getPaymentAmount() {
        return balance;
    }

    public VendingMachineStatus purchase(final PurchaseDrink purchaseDrink) {
        if (!isPurchaseAvailable()) {
            return VendingMachineStatus.NOT_AVAILABLE_PURCHASE;
        }

        drinks.canPurchase(purchaseDrink);
        balance -= drinks.getPurchaseAmount(purchaseDrink.getName());

        return VendingMachineStatus.AVAILABLE_PURCHASE;
    }

    private boolean isPurchaseAvailable() {
        return !drinks.isEmptyAll() &&
                balance >= drinks.getMinPurchaseAmount() &&
                coins.getTotalCoins() >= balance;
    }
}
