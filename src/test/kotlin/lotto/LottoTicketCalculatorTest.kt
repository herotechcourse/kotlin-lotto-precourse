package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
class LottoTicketCalculatorTest {
    @Test
    fun `calculates purchase ticket amounts`() {
        val purchaseAmount = 5000
        val ticketAmount = LottoTicketCalculator.calculateTicketAmount(purchaseAmount)

        assertThat(ticketAmount).isEqualTo(5)
    }
}