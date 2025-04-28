package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketCalculatorTest {

    private val calculator = LottoTicketCalculator()

    @Test
    fun `throws an exception with message when amount is not divisible by unit price`() {
        val invalidAmount = LottoTicketCalculator.LOTTO_UNIT_PRICE + 500
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculateTicketCount(invalidAmount)
        }
        assertThat(exception.message).isEqualTo(LottoTicketCalculator.INVALID_LOTTO_AMOUNT)
    }

    @Test
    fun `returns correct ticket count when amount is divisible by unit price`() {
        val validAmount = LottoTicketCalculator.LOTTO_UNIT_PRICE * 8
        val expectedCount = validAmount / LottoTicketCalculator.LOTTO_UNIT_PRICE

        val count = calculator.calculateTicketCount(validAmount)

        assertThat(count).isEqualTo(expectedCount)
    }

    @Test
    fun `returns zero when amount is zero`() {
        val amount = LottoTicketCalculator.ZERO

        val count = calculator.calculateTicketCount(amount)

        assertThat(count).isEqualTo(0)
    }
}
