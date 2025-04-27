package lotto.service

import lotto.domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class StatisticsTest {
    @Test
    fun `correctly calculates total prize and profit rate`() {
        // 1 × FIRST + 1 × FIFTH + 1 × NONE
        val ranks = listOf(Rank.FIRST, Rank.FIFTH, Rank.NONE)
        val stats = Statistics.from(ranks, purchaseAmount = 3000)

        // FIRST = 2_000_000_000, FIFTH = 5_000
        assertThat(stats.totalPrize()).isEqualTo(2_000_005_000)
        // ROI = 2_000_005_000 / 3000 * 100 = 66_666_833.333
        assertThat(stats.profitRate()).isEqualTo(66666833.3)
    }

    @Test
    fun `correctly calculates total prize and profit rate for mixed 2nd and 3rd prizes`() {
        // 1 × SECOND (30_000_000) + 2 × THIRD (1_500_000 each) = 33_000_000 total
        val ranks = listOf(Rank.SECOND, Rank.THIRD, Rank.THIRD)
        val stats = Statistics.from(ranks, purchaseAmount = 3000)

        assertThat(stats.totalPrize()).isEqualTo(30_000_000 + 1_500_000 * 2)
        // ROI = 33_000_000 / 3000 * 100 = 1_100_000.0%
        assertThat(stats.profitRate()).isEqualTo(1_100_000.0)
    }

    @Test
    fun `profit rate is zero when there are no winning tickets`() {
        val ranks = listOf(Rank.NONE, Rank.NONE)
        val stats = Statistics.from(ranks, purchaseAmount = 2000)

        assertThat(stats.totalPrize()).isZero()
        assertThat(stats.profitRate()).isEqualTo(0.0)
    }

    @Test
    fun `profit rate is zero when purchase amount is zero`() {
        val stats = Statistics.from(emptyList(), purchaseAmount = 0)
        assertThat(stats.totalPrize()).isEqualTo(0)
        assertThat(stats.profitRate()).isEqualTo(0.0)
    }
}
