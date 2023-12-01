package vendingmachine.domain.dto;

public record CoinDto(
        int coin500Count,
        int coin100Count,
        int coin50Count,
        int coin10Count
) {
}