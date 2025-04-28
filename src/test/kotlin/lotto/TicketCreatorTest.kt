package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketCreatorTest {

    @Test
    fun `createTickets creates correct number of tickets`() {
        val ticketCreator = TicketCreator()

        val moneySpent = 5000
        val tickets = ticketCreator.createTickets(moneySpent)

        assertThat(tickets).hasSize(moneySpent / 1000)
        tickets.forEach { ticket ->
            assertThat(ticket.numbersGetter()).hasSize(6)
        }
    }

    @Test
    fun `createTickets creates no tickets when money is zero`() {
        val ticketCreator = TicketCreator()

        val moneySpent = 0
        val tickets = ticketCreator.createTickets(moneySpent)

        assertThat(tickets).isEmpty()
    }
}
