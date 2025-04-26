package lotto

import lotto.domain.LottoMachine
import lotto.domain.Prize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    @Test
    fun `throws an exception when purchase amount is less than lotto price`() {
        assertThrows<IllegalArgumentException> { LottoMachine.generateTickets(500) }
    }

    @Test
    fun `throws an exception when purchase amount is not divisible by lotto price`() {
        assertThrows<IllegalArgumentException> { LottoMachine.generateTickets(1500) }
    }

    @Test
    fun `generates the correct number of lotto tickets`() {
        val tickets = LottoMachine.generateTickets(3000)
        assertEquals(3, tickets.size)
    }

    @Test
    fun `calculates correct results based on matching numbers and bonus number`() {
        // Create test tickets
        val ticket1 = Lotto(listOf(1, 2, 3, 4, 5, 6)) // 6 matches (FIRST)
        val ticket2 = Lotto(listOf(1, 2, 3, 4, 5, 7)) // 5 matches + bonus (SECOND)
        val ticket3 = Lotto(listOf(1, 2, 3, 4, 5, 8)) // 5 matches (THIRD)
        val ticket4 = Lotto(listOf(1, 2, 3, 4, 9, 10)) // 4 matches (FOURTH)
        val ticket5 = Lotto(listOf(1, 2, 3, 11, 12, 13)) // 3 matches (FIFTH)
        val ticket6 = Lotto(listOf(1, 2, 14, 15, 16, 17)) // 2 matches (no prize)

        val tickets = listOf(ticket1, ticket2, ticket3, ticket4, ticket5, ticket6)
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val result = LottoMachine.calculateResults(tickets, winningNumbers, bonusNumber)

        // Verify prize counts
        assertEquals(1, result.getPrizeCount(Prize.FIRST))
        assertEquals(1, result.getPrizeCount(Prize.SECOND))
        assertEquals(1, result.getPrizeCount(Prize.THIRD))
        assertEquals(1, result.getPrizeCount(Prize.FOURTH))
        assertEquals(1, result.getPrizeCount(Prize.FIFTH))

        // Verify total winnings
        val expectedTotal = Prize.FIRST.amount + Prize.SECOND.amount + 
                           Prize.THIRD.amount + Prize.FOURTH.amount + Prize.FIFTH.amount
        assertEquals(expectedTotal, result.getTotalWinnings())
    }
}
