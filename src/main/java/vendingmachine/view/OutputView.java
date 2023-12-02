package vendingmachine.view;

import vendingmachine.domain.dto.ChangeAmountDto;
import vendingmachine.domain.dto.VendingMachineCoinDto;

public class OutputView {
    private static final String HELD_AMOUNT_MESSAGE = System.lineSeparator() + """
            자판기가 보유한 동전
            500원-%d개
            100원-%d개
            50원-%d개
            10원-%d개
            """.stripIndent();
    private static final String CHANGE_MESSAGE = System.lineSeparator() + "잔돈 ";
    private static final String COIN_FORMAT = "%s원-%d개" + System.lineSeparator();

    public static void printVendingMachineAmount(final VendingMachineCoinDto coin) {
        System.out.printf(HELD_AMOUNT_MESSAGE, coin.coin500Count(), coin.coin100Count(), coin.coin50Count(),
                coin.coin10Count());
    }

    public static void printChangeAmount(final ChangeAmountDto changeAmountDto) {
        System.out.println(CHANGE_MESSAGE);

        changeAmountDto.coins()
                .forEach((key, value) -> System.out.printf(COIN_FORMAT, key, value));
    }
}