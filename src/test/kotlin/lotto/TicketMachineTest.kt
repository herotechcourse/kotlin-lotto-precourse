package lotto

import lotto.domain.TicketMachine
import lotto.util.INumberGenerator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Stub generator for deterministic testing.
 */

class TicketMachineTest {

    class StubGeneratorI(private val stubs: List<List<Int>>) : INumberGenerator {
        private var idx = 0
        override fun generate(): List<Int> = stubs[idx++]
    }

    @Test
    fun `issue correct number of tickets with given numbers`() {
        val stubNumbers = listOf(
            listOf(6,5,4,3,2,1),
            listOf(11,12,13,14,15,16)
        )
        val machine = TicketMachine(StubGeneratorI(stubNumbers))
        val tickets = machine.issue(2000)

        assertEquals(2, tickets.size)
        assertEquals(listOf(1,2,3,4,5,6), tickets[0].getNumbers())
        assertEquals(listOf(11,12,13,14,15,16), tickets[1].getNumbers())
    }

    @Test
    fun `issue zero tickets when amount is zero`() {
        val machine = TicketMachine(StubGeneratorI(emptyList()))
        val tickets = machine.issue(0)
        assertTrue(tickets.isEmpty())
    }
}
