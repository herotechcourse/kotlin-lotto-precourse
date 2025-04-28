package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicketGeneratorTest {

    @Test
    fun `should generate the correct number of tickets`() {
        val ticketGenerator = TicketGenerator(minNumber = 1, maxNumber = 45, numbersCount = 6)
        val tickets = ticketGenerator.generate(5)
        assertEquals(5, tickets.size)
    }

    @Test
    fun `each ticket should contain 6 unique numbers within the range of 1 to 45`() {
        val ticketGenerator = TicketGenerator(minNumber = 1, maxNumber = 45, numbersCount = 6)
        val tickets = ticketGenerator.generate(10)

        tickets.forEach { ticket ->
            assertEquals(6, ticket.size)
            assertTrue(ticket.all { it in 1..45 })
            assertEquals(ticket.size, ticket.toSet().size) // Ensure all numbers are unique
        }
    }
}
