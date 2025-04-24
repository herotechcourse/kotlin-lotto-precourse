package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ResultTest {
    @Test
    fun `returns correct total prize amount when all ranks are included`() {
        val ranks = listOf(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH)
        val result = Result(ranks)

        assertThat(result.totalPrizeInKRW()).isEqualTo(TOTAL_PRIZE)
    }

    @Test
    fun `returns correct return rate when only fifth rank is given`() {
        val ranks = listOf(Rank.FIFTH)
        val result = Result(ranks)

        assertThat(result.returnRate()).isEqualTo(0.2)
    }

    @Test
    fun `counts and sorts ranks correctly when multiple of each rank are given`() {
        val ranks = listOf(Rank.FIRST, Rank.FIRST, Rank.SECOND, Rank.SECOND, Rank.THIRD, Rank.THIRD)
        val result = Result(ranks)

        assertThat(result.sortedRankCounts()[Rank.FIRST]).isEqualTo(2)
        assertThat(result.sortedRankCounts()[Rank.SECOND]).isEqualTo(2)
        assertThat(result.sortedRankCounts()[Rank.THIRD]).isEqualTo(2)
    }

    companion object {
        private const val TOTAL_PRIZE = 2_031_555_000
    }
}
