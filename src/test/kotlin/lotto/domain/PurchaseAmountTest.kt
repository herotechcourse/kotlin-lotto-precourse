package lotto.domain

import lotto.domain.ErrorMessages.INVALID_PURCHASE_UNIT
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class PurchaseAmountTest {
    @Test
    fun `throws exception when amount is not divisible by 1_000`() {
        // given
        val amount = 1100
        
        // when
        
        // then
        assertThatThrownBy { PurchaseAmount(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INVALID_PURCHASE_UNIT)
    }

    @Test
    fun `thows exception when amount is zero`() {
        // given
        val amount = 0

        // when

        // then
        assertThatThrownBy { PurchaseAmount(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.INVALID_ZERO_PURCHASE_AMOUNT)
    }

    @Test
    fun `initializes successfully when amount is exactly 1_000`() {
        // given
        val amount = 1000

        // when
        val result = PurchaseAmount(amount)

        // then
        assertThat(result.amount).isEqualTo(1000)
    }
}
