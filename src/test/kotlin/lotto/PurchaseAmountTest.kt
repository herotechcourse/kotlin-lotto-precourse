package lotto

import lotto.domain.Lotto
import lotto.domain.PurchaseAmount
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatThrownBy

class PurchaseAmountTest {
    @Test
    fun `throws an exception when purchase number is 0 or less`() {
        // given
        val invalidNumber = -1

        // when & then
        assertThatThrownBy { PurchaseAmount(invalidNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERR] The Purchase amount must be positive. Please enter again.")
    }

    @Test
    fun `throws an exception when purchase number is less than single lottery price`() {
        // given
        val invalidNumber = Lotto.PRICE - 1

        // when & then
        assertThatThrownBy { PurchaseAmount(invalidNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERR] The purchase amount must be greater than or equal to the single lottery ticket price(1,000KRW). Please enter again.")
    }
}
