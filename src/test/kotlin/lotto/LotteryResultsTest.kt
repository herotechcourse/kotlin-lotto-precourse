package lotto

import lotto.PrizeRanking.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LotteryResultsTest {
    private val lotteryResults = LotteryResults()
    @Test
    fun `calculate winning statistics`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 8, 9)),
            Lotto(listOf(1, 2, 3, 8, 9, 10))
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7


        val statistics = lotteryResults.getStatistics(tickets, winningNumbers, bonusNumber)

        assertEquals(5, statistics.size)
        assertTrue(statistics.any { it.contains("6 Matches") })
        assertTrue(statistics.any { it.contains("5 Matches + Bonus Ball") })
        assertTrue(statistics.any { it.contains("5 Matches") })
        assertTrue(statistics.any { it.contains("4 Matches") })
        assertTrue(statistics.any { it.contains("3 Matches") })
    }

    @Test
    fun `calculate return rate`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val purchaseAmount = 1000

        lotteryResults.getStatistics(tickets, winningNumbers, bonusNumber)
        val returnRate = lotteryResults.calculateReturnRate(purchaseAmount)

        assertEquals("200000000.0", returnRate)
    }

    @Test
    fun `calculate first place prize`() {
        val matchCount = 6
        val hasBonus = false
        assertEquals(FIRST.prize, lotteryResults.getRank(matchCount, hasBonus))
    }

    @Test
    fun `calculate second place prize`() {
        val matchCount = 5
        val hasBonus = true
        assertEquals(SECOND.prize, lotteryResults.getRank(matchCount, hasBonus))
    }

    @Test
    fun `calculate third place prize`() {
        val matchCount = 5
        val hasBonus = false
        assertEquals(THIRD.prize, lotteryResults.getRank(matchCount, hasBonus))
    }

    @Test
    fun `calculate fourth place prize`() {
        val matchCount = 4
        val hasBonus = false
        assertEquals(FOURTH.prize, lotteryResults.getRank(matchCount, hasBonus))
    }

    @Test
    fun `calculate fifth place prize`() {
        val matchCount = 3
        val hasBonus = false
        assertEquals(FIFTH.prize, lotteryResults.getRank(matchCount, hasBonus))
    }

    @Test
    fun `calculate no prize`() {
        val matchCount = 2
        val hasBonus = false
        assertEquals(NONE.prize, lotteryResults.getRank(matchCount, hasBonus))
    }
}
