package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResultEvaluatorTest {

    @Test
    fun `should correctly evaluate ranks and total winnings`() {
        // Arrange
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 Matches
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 Matches + Bonus
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 Matches
            Lotto(listOf(1, 2, 3, 4, 10, 11)), // 4 Matches
            Lotto(listOf(1, 2, 3, 12, 13, 14)), // 3 Matches
            Lotto(listOf(20, 21, 22, 23, 24, 25)) // No Matches
        )
        val evaluator = ResultEvaluator(winningNumbers, bonusNumber)

        // Act
        val result = evaluator.evaluate(tickets)

        // Assert
        assertEquals(1, result.rankCounts[Rank.FIRST]) // 6 Matches
        assertEquals(1, result.rankCounts[Rank.SECOND]) // 5 Matches + Bonus
        assertEquals(1, result.rankCounts[Rank.THIRD]) // 5 Matches
        assertEquals(1, result.rankCounts[Rank.FOURTH]) // 4 Matches
        assertEquals(1, result.rankCounts[Rank.FIFTH]) // 3 Matches
        assertEquals(1, result.rankCounts[Rank.NONE]) // No Matches
        assertEquals(
            Rank.FIRST.prize + Rank.SECOND.prize + Rank.THIRD.prize + Rank.FOURTH.prize + Rank.FIFTH.prize,
            result.totalWinnings
        )
    }

    @Test
    fun `should calculate correct profit rate`() {
        // Arrange
        val rankCounts = mapOf(
            Rank.FIRST to 1,
            Rank.SECOND to 0,
            Rank.THIRD to 0,
            Rank.FOURTH to 0,
            Rank.FIFTH to 0
        )
        val totalWinnings = Rank.FIRST.prize
        val result = ResultEvaluator.Result(rankCounts, totalWinnings)

        // Act
        val profitRate = result.calculateProfitRate(10_000)

        // Assert
        assertEquals(20000000.0, profitRate, 0.1)
    }
}