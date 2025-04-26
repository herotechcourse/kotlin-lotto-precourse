package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class StatisticTest {
    /**
     * Tests for totalPrizeInKRW()
     * - Sums prize amounts for all ranks correctly
     */
    @Test
    fun `returns correct total prize amount when all ranks are included`() {
        val ranks = listOf(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH)
        val statistic = Statistic(ranks)

        assertThat(statistic.totalPrizeInKRW()).isEqualTo(TOTAL_PRIZE)
    }

    /**
     * Tests for returnRate()
     * - Calculates return rate correctly when only one low-rank (FIFTH) is given
     */
    @Test
    fun `returns correct return rate when only fifth rank is given`() {
        val ranks = listOf(Rank.FIFTH)
        val statistic = Statistic(ranks)

        assertThat(statistic.returnRate()).isEqualTo(5.0)
    }

    /**
     * Tests for sortedRankCounts()
     * - Groups and counts rank occurrences correctly
     */
    @Test
    fun `counts and sorts ranks correctly when multiple of each rank are given`() {
        val ranks = listOf(Rank.FIRST, Rank.FIRST, Rank.SECOND, Rank.SECOND, Rank.THIRD, Rank.THIRD)
        val statistic = Statistic(ranks)

        assertThat(statistic.sortedRankCounts()[Rank.FIRST]).isEqualTo(2)
        assertThat(statistic.sortedRankCounts()[Rank.SECOND]).isEqualTo(2)
        assertThat(statistic.sortedRankCounts()[Rank.THIRD]).isEqualTo(2)
    }

    /**
     * Tests for returnRate() with no winning ranks
     * - Ensures return rate is 0.0 when only nulls are present
     */
    @Test
    fun `returns 0 return rate when no ranks are given`() {
        val ranks = listOf(null)
        val statistic = Statistic(ranks)

        assertThat(statistic.returnRate()).isEqualTo(0.0)
    }

    /**
     * Tests for returnRate() with nulls included
     * - Ignores null values in ranks when calculating return rate
     */
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
