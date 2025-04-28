package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = [900, 999, 100001, 101000])
    fun `throw exception when the purchase amount is out of range`(value: Int) {
        // when & then
        assertThatThrownBy { LottoPurchaseAmount(value) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Purchase amount should be between $TICKET_PRICE and $MAX_PURCHASE_AMOUNT KRW.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1001, 1100, 5500])
    fun `throw exception when the purchase amount is not divisible by ticket price`(value: Int) {
        // when & then
        assertThatThrownBy { LottoPurchaseAmount(value) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Purchase amount should be divisible by $TICKET_PRICE.")
    }

    companion object {
        private const val TICKET_PRICE: Int = 1_000
        private const val MAX_PURCHASE_AMOUNT: Int = 100_000

    }
}

