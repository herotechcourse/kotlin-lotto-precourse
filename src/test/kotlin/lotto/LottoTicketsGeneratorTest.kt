package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsGeneratorTest {
    private val lottoTicketsGenerator = LottoTicketsGenerator()

    @Test
    fun `should generate correct number of tickets based on amount`() {
        val amount = 5000

        val ticketsAmount = lottoTicketsGenerator.generateTickets(amount)
        assertThat(ticketsAmount.size).isEqualTo(5)
        ticketsAmount.forEach { ticket ->
            assertThat(ticket.getNumbers()).hasSize(6)

            assertThat(ticket.getNumbers().all { it in 1..45 }).isTrue
        }
    }
}