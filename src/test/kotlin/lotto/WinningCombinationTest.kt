package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WinningCombinationTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusBall = 7

    @Test
    fun `match correctly counts prizes`() {
        val lottoTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 Matches
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 Matches + Bonus Ball
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 Matches
            Lotto(listOf(1, 2, 3, 4, 7, 8)), // 4 Matches
            Lotto(listOf(1, 2, 3, 7, 8, 9))  // 3 Matches
        )

        val winningCombination = WinningCombination(winningNumbers, bonusBall, 0)

        val prizeResult = winningCombination.match(lottoTickets)

        assertEquals(1, prizeResult[Prize.FIRST])
        assertEquals(1, prizeResult[Prize.SECOND])
        assertEquals(1, prizeResult[Prize.THIRD])
        assertEquals(1, prizeResult[Prize.FOURTH])
        assertEquals(1, prizeResult[Prize.FIFTH])
    }

    @Test
    fun `calculate total prize money correctly`() {
        val lottoTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 Matches
            Lotto(listOf(1, 2, 3, 4, 5, 7))  // 5 Matches + Bonus Ball
        )

        val winningCombination = WinningCombination(winningNumbers, bonusBall, 0)

        winningCombination.match(lottoTickets)

        val expectedTotalPrize = Prize.FIRST.money + Prize.SECOND.money

        assertEquals(expectedTotalPrize, winningCombination.getTotalPrize())
    }
}