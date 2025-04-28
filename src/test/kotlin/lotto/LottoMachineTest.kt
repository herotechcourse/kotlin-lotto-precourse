package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LottoMachineTest {

    @Test
    fun `throws exception when purchase amount is less than ticket price`() {
        val machine = LottoMachine()
        assertThrows(IllegalArgumentException::class.java) {
            machine.generateTickets(500)
        }
    }

    @Test
    fun `throws exception when purchase amount is not multiple of ticket price`() {
        val machine = LottoMachine()
        assertThrows(IllegalArgumentException::class.java) {
            machine.generateTickets(1500)
        }
    }

    @Test
    fun `generates correct number of tickets`() {
        val machine = LottoMachine()
        val tickets = machine.generateTickets(3000)
        assertEquals(3, tickets.size)
        tickets.forEach { ticket ->
            assertEquals(6, ticket.getNumbers().size)
            assertTrue(ticket.getNumbers().all { it in 1..45 })
        }
    }

    @Test
    fun `calculates correct result for tickets`() {
        val machine = LottoMachine()
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 7, 8, 9))
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 10)
        val bonusNumber = 6

        val result = machine.calculateResult(tickets, winningNumbers, bonusNumber)
        assertEquals(1, result.getWinCount(LottoGrade.SECOND))
        assertEquals(1, result.getWinCount(LottoGrade.FIFTH))
    }
}