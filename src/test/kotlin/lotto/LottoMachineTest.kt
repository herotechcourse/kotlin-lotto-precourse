package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    private val lottoMachine = LottoMachine()

    @Test
    fun `generateTickets should return correct number of tickets`() {
        val ticketCount = 5
        val tickets = lottoMachine.generateTickets(ticketCount)

        assertEquals(ticketCount, tickets.size)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -100])
    fun `generateTickets should throw exception for invalid ticket count`(invalidCount: Int) {
        assertThrows<IllegalArgumentException> {
            lottoMachine.generateTickets(invalidCount)
        }
    }

    @Test
    fun `each generated ticket should have 6 unique numbers between 1 and 45`() {
        val tickets = lottoMachine.generateTickets(100) // Stress test

        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            assertEquals(6, numbers.size)
            assertEquals(6, numbers.distinct().size)
            assertTrue(numbers.all { it in 1..45 })
            assertEquals(numbers, numbers.sorted())
        }
    }
}