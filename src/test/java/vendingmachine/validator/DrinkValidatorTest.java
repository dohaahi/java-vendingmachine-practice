package vendingmachine.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.Money;

class DrinkValidatorTest {
    @Test
    @NullAndEmptySource
    void 빈_값이_입력되면_예외_발생(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> DrinkValidator.validateInputDrink(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @ValueSource(strings = {"a", "가"})
    void 정수가_아닌_값이_입력되면_예외_발생(final String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> DrinkValidator.validateInputDrink(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @ValueSource(ints = {0, 90})
    void 상품_금액이_최소값_미만이면_예외_발생(final int amount) {
        // given
        Money money = Money.from(amount);

        // when
        // then
        assertThatThrownBy(() -> DrinkValidator.validateMinDrinkPurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}