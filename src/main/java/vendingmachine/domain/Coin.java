package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.List;

public enum Coin {
    NONE(0),
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);
    private static final List<Coin> coins = List.of(values());
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin pickRandomCoin(final int amount) {
        int pickedCoin = pickNumberInList(setCoinList(amount));

        return coins.stream()
                .filter(coin -> coin.getAmount() == pickedCoin)
                .findAny()
                .orElse(NONE);
    }

    private static List<Integer> setCoinList(final int amount) {
        return coins.stream()
                .filter(coin -> coin != NONE)
                .map(Coin::getAmount)
                .filter(coinAmount -> coinAmount <= amount)
                .toList();
    }

    public static List<Coin> getCoins() {
        return coins;
    }

    public int getAmount() {
        return amount;
    }
}