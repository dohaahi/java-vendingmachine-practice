package vendingmachine.domain;

import static vendingmachine.validator.MoneyValidator.validateMoney;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.domain.dto.VendingMachineCoinDto;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(final int amount) {
        validateMoney(amount);
        coins = makeCoins(amount);
    }

    public static Coins from(final int amount) {
        return new Coins(amount);
    }

    public VendingMachineCoinDto toCoinDto() {
        return new VendingMachineCoinDto(coins.get(Coin.COIN_500), coins.get(Coin.COIN_100), coins.get(Coin.COIN_50),
                coins.get(Coin.COIN_10));
    }

    public int getTotalCoins() {
        return coins.entrySet().stream().mapToInt(coins -> coins.getKey().getAmount() * coins.getValue()).sum();
    }

    public Map<Integer, Integer> getChange(final int balance) {
        // coins를 순회하며 count만큼 totalChange-총잔돈에 추가
        // 만약, 총잔돈이 balance-잔액보다 크면 return
        Map<Integer, Integer> change = new LinkedHashMap<>();
        int totalChange = 0;

        for (Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin coin = entry.getKey();
            Integer coinCount = entry.getValue();

            while (totalChange < balance && coinCount > 0 && totalChange + coin.getAmount() <= balance) {
                totalChange += coin.getAmount();
                change.put(coin.getAmount(), coinCount + 1);
                coinCount--;
            }
        }

        return change;
    }

    private Map<Coin, Integer> makeCoins(final int amount) {
        Map<Coin, Integer> coins = generateCoinStorage();

        return makeCoinsRecursive(amount, coins);
    }

    private Map<Coin, Integer> generateCoinStorage() {
        Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
        int initCount = 0;

        Coin.getCoins().forEach(coin -> coins.put(coin, initCount));

        return coins;
    }

    private Map<Coin, Integer> makeCoinsRecursive(int remainingCoins, final Map<Coin, Integer> coins) {
        if (remainingCoins <= 0) {
            return coins;
        }

        Coin randomCoin = Coin.pickRandomCoin(remainingCoins);

        coins.computeIfPresent(randomCoin, (coin, count) -> count + 1);
        remainingCoins -= randomCoin.getAmount();

        return makeCoinsRecursive(remainingCoins, coins);
    }
}
