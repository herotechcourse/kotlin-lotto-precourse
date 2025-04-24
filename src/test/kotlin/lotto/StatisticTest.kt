package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class StatisticTest {
    @Test
    fun `returns correct total prize amount when all ranks are included`() {
        val ranks = listOf(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH)
        val statistic = Statistic(ranks)

        assertThat(statistic.totalPrizeInKRW()).isEqualTo(TOTAL_PRIZE)
    }

    @Test
    fun `returns correct return rate when only fifth rank is given`() {
        val ranks = listOf(Rank.FIFTH)
        val statistic = Statistic(ranks)

        assertThat(statistic.returnRate()).isEqualTo(5.0)
    }

    @Test
    fun `counts and sorts ranks correctly when multiple of each rank are given`() {
        val ranks = listOf(Rank.FIRST, Rank.FIRST, Rank.SECOND, Rank.SECOND, Rank.THIRD, Rank.THIRD)
        val statistic = Statistic(ranks)

        assertThat(statistic.sortedRankCounts()[Rank.FIRST]).isEqualTo(2)
        assertThat(statistic.sortedRankCounts()[Rank.SECOND]).isEqualTo(2)
        assertThat(statistic.sortedRankCounts()[Rank.THIRD]).isEqualTo(2)
    }

    @Test
    fun `returns 0 return rate when no ranks are given`() {
        val ranks = listOf(null)
        val statistic = Statistic(ranks)

        assertThat(statistic.returnRate()).isEqualTo(0.0)
    }

    @Test
    fun `ignores null ranks when calculating return rate`() {
        val ranks = listOf(Rank.FIFTH, null)
        val statistic = Statistic(ranks)

        assertThat(statistic.returnRate()).isEqualTo(2.5)
    }

    companion object {
        private const val TOTAL_PRIZE = 2_031_555_000
    }
}
