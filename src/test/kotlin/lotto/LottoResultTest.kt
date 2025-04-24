package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {

    @Test
    fun `getRankCounts should return all prize ranks with their counts`() {
        val tickets = listOf(
            createLotto(1, 2, 3, 4, 5, 6),  // 6 matches (1st prize)
            createLotto(1, 2, 3, 4, 5, 10), // 5 matches with bonus 10
            createLotto(1, 2, 3, 4, 8, 9),  // 4 matches
            createLotto(1, 2, 3, 11, 12, 13), // 3 matches
            createLotto(7, 8, 9, 11, 12, 13)  // 0 matches (no prize)
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 10

        val lottoResult = LottoResult(tickets, winningNumbers, bonusNumber)
        val rankCounts = lottoResult.getRankCounts()

        assertThat(rankCounts).hasSize(5) // All prize ranks except NONE
        assertThat(rankCounts[PrizeRank.SIX_MATCH]).isEqualTo(1)
        assertThat(rankCounts[PrizeRank.FIVE_MATCH_BONUS]).isEqualTo(1)
        assertThat(rankCounts[PrizeRank.FIVE_MATCH]).isEqualTo(0)
        assertThat(rankCounts[PrizeRank.FOUR_MATCH]).isEqualTo(1)
        assertThat(rankCounts[PrizeRank.THREE_MATCH]).isEqualTo(1)
        assertThat(rankCounts).doesNotContainKey(PrizeRank.NONE)
    }

    @ParameterizedTest
    @CsvSource(
        "8000, 2031555000, 25394437.5", // All prizes
        "8000, 0, 0.0",                 // No matches
        "1000, 5000, 500.0",             // 3 matches
        "1000, 2000000000, 200000000.0", // 6 matches
        "1000, 30000000, 3000000.0",     // 5 matches with bonus
        "1000, 1500000, 150000.0",       // 5 matches
        "1000, 50000, 5000.0"           // 4 matches
    )
    fun `getProfitRate should calculate correct profit percentage`(
        purchaseAmount: Int,
        expectedWinnings: Int,
        expectedProfitRate: Double
    ) {
        val lottoResult = createLottoResultWithWinnings(expectedWinnings)

        val profitRate = lottoResult.getProfitRate(purchaseAmount)

        assertThat(profitRate).isEqualTo(expectedProfitRate)
    }

    @Test
    fun `empty ticket list should return zero for all ranks`() {
        val tickets = emptyList<Lotto>()
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val lottoResult = LottoResult(tickets, winningNumbers, bonusNumber)
        val rankCounts = lottoResult.getRankCounts()

        assertThat(rankCounts).hasSize(5)
        assertThat(rankCounts.values).containsOnly(0)
    }

    private fun createLotto(vararg numbers: Int): Lotto {
        return Lotto(numbers.toList())
    }

    private fun createLottoResultWithWinnings(totalWinnings: Int): LottoResult {
        val tickets = mutableListOf<Lotto>()

        when (totalWinnings) {
            0 -> { /* No tickets needed for zero winnings */ }
            5000 -> tickets.add(createLotto(1, 2, 3, 45, 44, 43))
            50000 -> tickets.add(createLotto(1, 2, 3, 4, 44, 43))
            1500000 -> tickets.add(createLotto(1, 2, 3, 4, 5, 44))
            30000000 -> tickets.add(createLotto(1, 2, 3, 4, 5, 45))
            2000000000 -> tickets.add(createLotto(1, 2, 3, 4, 5, 6))
            2031555000 -> {
                tickets.add(createLotto(1, 2, 3, 4, 5, 6))
                tickets.add(createLotto(1, 2, 3, 4, 5, 45))
                tickets.add(createLotto(1, 2, 3, 4, 5, 44))
                tickets.add(createLotto(1, 2, 3, 4, 44, 43))
                tickets.add(createLotto(1, 2, 3, 43, 44, 45))
            }
        }

        return LottoResult(tickets, listOf(1, 2, 3, 4, 5, 6), 45)
    }
}