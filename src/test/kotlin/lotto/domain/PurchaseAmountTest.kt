package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountTest {
    @ValueSource(ints = [999, 0, -123])
    @ParameterizedTest
    fun `throws an exception when purchase number is less than single lottery price`() {
        // given
        val invalidNumber = Lotto.PRICE - 1

        // when & then
        assertThatThrownBy { PurchaseAmount(invalidNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("The purchase amount must be greater than or equal to the single lottery ticket price(1,000KRW)")
    }

    @Test
    fun `calculate purchasable tickets by amount`() {
        // given
        val exceptedCount = 3
        val rawAmount = Lotto.PRICE * exceptedCount

        // when
        val realCount = PurchaseAmount(rawAmount).countPurchasableTickets(Lotto.PRICE)

        // then
        assertThat(realCount).isEqualTo(exceptedCount)

    }
}
