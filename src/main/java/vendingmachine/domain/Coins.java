package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import vendingmachine.domain.dto.CoinDto;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins() {
        Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
        final int initChangeCount = 0;

        Coin.getCoins()
                .forEach(coin -> {
                    coins.put(coin, initChangeCount);
                });

        this.coins = coins;
    }

    public void makeChangeUntilAmountEmpty(final Money amount) {
        int nextAmount = amount.getAmount();

        while (nextAmount != 0 && nextAmount > 0) {
            nextAmount -= makeChange(nextAmount);
        }
    }

    private int makeChange(final int amount) {
        Set<Entry<Coin, Integer>> entries = coins.entrySet();
        Coin randomCoin = Coin.pickRandomCoin(amount);

        for (Entry<Coin, Integer> coin : coins.entrySet()) {

            int coinCount = coin.getValue();
            if (coin.getKey().equals(randomCoin)) {
                coinCount++;
            }

            coin.setValue(coinCount);
        }
        return randomCoin.getAmount();
    }

    public CoinDto toCoinDto() {
        return new CoinDto(
                coins.get(Coin.COIN_500),
                coins.get(Coin.COIN_100),
                coins.get(Coin.COIN_50),
                coins.get(Coin.COIN_10)
        );
    }
}
