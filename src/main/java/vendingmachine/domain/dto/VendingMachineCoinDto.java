package vendingmachine.domain.dto;

public record VendingMachineCoinDto(
        int coin500Count,
        int coin100Count,
        int coin50Count,
        int coin10Count
) {
}