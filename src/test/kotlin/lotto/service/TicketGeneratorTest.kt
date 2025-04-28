package lotto.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicketGeneratorTest {

    private val generator = TicketGenerator()

    @Test
    fun `generate with zero count returns empty list`() {
        val tickets = generator.generate(0)
        assertTrue(tickets.isEmpty(), "Expected no tickets when count is zero")
    }

    @Test
    fun `generate returns correct number of tickets`() {
        val count = 10
        val tickets = generator.generate(count)
        assertEquals(count, tickets.size, "Should generate exactly \$count tickets")
    }

    @Test
    fun `each ticket contains exactly six numbers`() {
        val tickets = generator.generate(5)
        tickets.forEach { ticket ->
            assertEquals(
                6, ticket.getNumbers().size,
                "Each ticket must have exactly 6 numbers"
            )
        }
    }

    @Test
    fun `numbers in each ticket are sorted and unique and within range 1 to 45`() {
        val tickets = generator.generate(20)
        tickets.forEach { ticket ->
            val nums = ticket.getNumbers()
            assertTrue(
                nums.zipWithNext().all { (a, b) -> a < b },
                "Numbers must be in strictly increasing order"
            )
            assertEquals(
                6, nums.distinct().size,
                "Numbers must be unique"
            )
            assertTrue(
                nums.all { it in 1..45 },
                "Each number must be between 1 and 45"
            )
        }
    }

}