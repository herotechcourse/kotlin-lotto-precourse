package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningStatisticsTest {
    @Test
    fun `calculate() returns statistics`(){
        val lottoTickets = listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(13, 14, 16, 38, 42, 45)),
            Lotto(listOf(7, 11, 30, 40, 42, 43)),
            Lotto(listOf(2, 13, 22, 32, 38, 45)),
            Lotto(listOf(1, 3, 5, 14, 22, 45))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val result = WinningStatistics.calculate(lottoTickets, winningLotto, bonusNumber)

        assert(result[Rank.FIRST] == 0) { "First rank should be zero." }
        assert(result[Rank.SECOND] == 0) { "Second rank should be zero." }
        assert(result[Rank.THIRD] == 0) { "Third rank should be zero." }
        assert(result[Rank.FOURTH] == 0) { "Fourth rank should be zero." }
        assert(result[Rank.FIFTH] == 1) { "Fifth rank should be one." }
    }
}