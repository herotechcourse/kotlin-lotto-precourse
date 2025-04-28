package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsTest {

    @Test
    fun `creates multiple LottoTickets based on the amount`() {
        val amount = 8000
        val tickets = LottoTickets.generate(Money(amount))

        assertThat(tickets.getTickets()).hasSize(8)
    }
}