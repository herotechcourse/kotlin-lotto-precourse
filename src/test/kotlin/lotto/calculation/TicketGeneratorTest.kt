package lotto.calculation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TicketGeneratorTest {

    private val ticketGenerator = TicketGenerator()

    @Test
    fun `generates correct number of Lotto tickets with 6 unique numbers each`() {
        val numberOfTickets = 5  // Example: generating 5 tickets
        val tickets = ticketGenerator.generateTickets(numberOfTickets)

        // Ensure the correct number of tickets are generated
        assertEquals(numberOfTickets, tickets.size, "The number of generated tickets should match the input number.")

        // Ensure each ticket contains exactly 6 unique numbers within the range 1–45
        tickets.forEach { ticket ->
            assertEquals(6, ticket.getNumbers().size, "Each ticket should contain exactly 6 numbers.")
            assertTrue(ticket.getNumbers().all { it in 1..45 }, "Each number in the ticket should be between 1 and 45.")
            assertEquals(ticket.getNumbers().toSet().size, ticket.getNumbers().size, "Each ticket should contain unique numbers.")
        }
    }
}