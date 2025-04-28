package lotto.process

import lotto.PurchaseAmount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketGeneratorTest {
    private val ticketGenerator = TicketGenerator()

    @Test
    fun `generateTickets should generate correct number of tickets`() {
        val purchaseAmount = PurchaseAmount(5000)
        val tickets = ticketGenerator.generateTickets(purchaseAmount)
        assertThat(tickets).hasSize(5)
    }

    @Test
    fun `each generated ticket should have 6 unique numbers between 1 and 45`() {
        val purchaseAmount = PurchaseAmount(3000)
        val tickets = ticketGenerator.generateTickets(purchaseAmount)
        tickets.forEach { ticket ->
            assertThat(ticket.getLottoNumber())
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allMatch { it in 1..45 }
        }
    }
}