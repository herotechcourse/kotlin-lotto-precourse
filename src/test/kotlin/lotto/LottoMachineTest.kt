package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class LottoMachineTest {
    private val lottoMachine = LottoMachine()

    @Test
    @DisplayName("Generated ticket count should match requested amount")
    fun `generateTickets should return correct number of tickets`() {
        val ticketCount = 5
        val tickets = lottoMachine.generateTickets(ticketCount)
        assertEquals(ticketCount, tickets.size)
    }

    @Test
    @DisplayName("Each ticket should contain exactly 6 numbers")
    fun `each ticket should have 6 numbers`() {
        val tickets = lottoMachine.generateTickets(1)
        assertEquals(6, tickets[0].getNumbers().size)
    }

    @Test
    @DisplayName("Numbers in each ticket should be sorted")
    fun `numbers should be sorted`() {
        val tickets = lottoMachine.generateTickets(10) // Test multiple tickets
        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            assertTrue(numbers == numbers.sorted(), "Numbers should be in ascending order")
        }
    }

    @Test
    @DisplayName("All numbers should be within 1-45 range")
    fun `numbers should be within valid range`() {
        val tickets = lottoMachine.generateTickets(10) // Test multiple tickets
        tickets.forEach { ticket ->
            ticket.getNumbers().forEach { number ->
                assertTrue(number in 1..45, "Each number should be between 1 and 45")
            }
        }
    }

    @Test
    @DisplayName("Ticket numbers should not contain duplicates")
    fun `numbers should not contain duplicates`() {
        val tickets = lottoMachine.generateTickets(10) // Test multiple tickets
        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            assertEquals(numbers.toSet().size, 6, "All numbers in a ticket should be unique")
        }
    }
}