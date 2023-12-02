package vendingmachine.domain.dto;

import java.util.Map;

public record ChangeAmountDto(Map<Integer, Integer> coins) {
}