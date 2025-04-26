package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoStatisticsTest {

    @Test
    fun `counts tickets correctly per rank`() {
        // Given: A list of ranks (fake results)
        val ranks = listOf(
            Rank.FIRST,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.THIRD,
            Rank.FOURTH,
            Rank.MISS,
            Rank.MISS
        )

        val statistics = LottoStatistics(ranks)
        val rankCounts = statistics.getRankCounts()

        assertThat(rankCounts[Rank.FIRST]).isEqualTo(1)
        assertThat(rankCounts[Rank.FIFTH]).isEqualTo(2)
        assertThat(rankCounts[Rank.THIRD]).isEqualTo(1)
        assertThat(rankCounts[Rank.FOURTH]).isEqualTo(1)
        assertThat(rankCounts[Rank.MISS]).isEqualTo(2)
    }

    @Test
    fun `calculates profit rate correctly`() {

        val ranks = listOf(Rank.FIFTH)
        val purchaseAmount = 1000
        val statistics = LottoStatistics(ranks)
        val profitRate = statistics.calculateProfitRate(purchaseAmount)

        assertThat(profitRate).isEqualTo(500.0)
    }

    @Test
    fun `profit rate is zero if no wins`() {

        val ranks = listOf(Rank.MISS, Rank.MISS, Rank.MISS)
        val purchaseAmount = 3000
        val statistics = LottoStatistics(ranks)
        val profitRate = statistics.calculateProfitRate(purchaseAmount)

        assertThat(profitRate).isEqualTo(0.0)
    }
}
