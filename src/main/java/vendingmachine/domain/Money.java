package vendingmachine.domain;

import static vendingmachine.validator.MoneyValidator.validateMoney;

import vendingmachine.domain.dto.MoneyDto;

public class Money {
    private final int amount;

    private Money(int amount) {
        validateMoney(amount);
        this.amount = amount;
    }

    public static Money from(final int amount) {
        return new Money(amount);
    }

    public MoneyDto toMoneyDto() {
        return new MoneyDto(amount);
    }

    public int getAmount() {
        return amount;
    }
}
