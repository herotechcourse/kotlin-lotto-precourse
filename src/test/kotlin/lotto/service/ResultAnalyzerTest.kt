package lotto.service

import lotto.Lotto
import lotto.core.BonusNumber
import lotto.core.Rank
import lotto.core.WinningNumbers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ResultAnalyzerTest {

    private val analyzer = ResultAnalyzer()

    @Test
    fun `analyze returns zero counts when no tickets`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7)

        val stats = analyzer.analyze(emptyList(), winningNumbers, bonusNumber)

        // All ranks should be zero
        Rank.entries.forEach { rank ->
            assertEquals(0, stats[rank], "Expected 0 tickets for rank $rank")
        }
    }

    @Test
    fun `analyze correctly counts each prize rank`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7)

        // Build tickets hitting each possible rank
        val ticket3Match = Lotto(listOf(1, 2, 3, 10, 11, 12))      // 3 matches
        val ticket4Match = Lotto(listOf(1, 2, 3, 4, 10, 11))       // 4 matches
        val ticket5NoB = Lotto(listOf(1, 2, 3, 4, 5, 10))        // 5 matches without bonus
        val ticket5WithB = Lotto(listOf(1, 2, 3, 4, 5, 7))         // 5 matches + bonus
        val ticket6Match = Lotto(listOf(1, 2, 3, 4, 5, 6))         // 6 matches

        val tickets = listOf(
            ticket3Match,
            ticket4Match,
            ticket5NoB,
            ticket5WithB,
            ticket6Match
        )

        val stats = analyzer.analyze(tickets, winningNumbers, bonusNumber)

        assertEquals(1, stats[Rank.THREE], "Should count one 3-match ticket")
        assertEquals(1, stats[Rank.FOUR], "Should count one 4-match ticket")
        assertEquals(1, stats[Rank.FIVE], "Should count one 5-match ticket without bonus")
        assertEquals(1, stats[Rank.FIVE_PLUS], "Should count one 5-match+bonus ticket")
        assertEquals(1, stats[Rank.SIX], "Should count one 6-match ticket")
    }
}