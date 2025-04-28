package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class TicketGenerationTest {

    @Test
    fun `generateTickets returns correct number of tickets`() {
        val tickets = generateTickets(5)
        assertThat(tickets).hasSize(5)
    }

    @Test
    fun `each ticket has 6 unique numbers in range 1 to 45 and is sorted`() {
        val tickets = generateTickets(10)
        tickets.forEach { ticket ->
            // exactly 6 numbers
            assertThat(ticket).hasSize(6)
            // all numbers between 1 and 45
            assertThat(ticket).allMatch { it in 1..45 }
            // all unique
            assertThat(ticket.toSet()).hasSize(6)
            // sorted ascending
            assertThat(ticket).isSorted()
        }
    }

    @Test
    fun `generateTickets with zero count returns empty list`() {
        val tickets = generateTickets(0)
        assertThat(tickets).isEmpty()
    }
}
