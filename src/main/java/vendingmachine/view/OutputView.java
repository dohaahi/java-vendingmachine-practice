package vendingmachine.view;

import vendingmachine.domain.dto.CoinDto;

public class OutputView {
    private static final String HELD_AMOUNT_MESSAGE =
            System.lineSeparator() +
                    """
                            자판기가 보유한 동전
                            500원-%d개
                            100원-%d개
                            50원-%d개
                            10원-%d개
                            """.stripIndent();

    public static void printVendingMachineAmount(final CoinDto coin) {
        System.out.printf(HELD_AMOUNT_MESSAGE, coin.coin500Count(), coin.coin100Count(), coin.coin50Count(),
                coin.coin10Count());
    }
}
