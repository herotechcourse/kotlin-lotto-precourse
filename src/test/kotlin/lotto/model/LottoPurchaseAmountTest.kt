package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoPurchaseAmountTest {
    @Test
    fun `creates LottoPurchaseAmount successfully with valid amount`() {
        val purchaseAmount = LottoPurchaseAmount(5 * LOTTO_PRICE)

        assertThat(purchaseAmount.toCount()).isEqualTo(5)
    }

    @Test
    fun `throws exception when amount is less than minimum`() {
        assertThatThrownBy { LottoPurchaseAmount(LOTTO_PRICE - 1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `throws exception when amount is not divisible by LOTTO_PRICE`() {
        val invalidAmount = LOTTO_PRICE * 2 + (LOTTO_PRICE / 2)  // makes the test robust against Lotto price changes
        assertThatThrownBy { LottoPurchaseAmount(invalidAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
