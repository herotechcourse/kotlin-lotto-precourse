package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {
    @Test
    fun `calculates total prize and profit rate correctly when some ranks are won`() {
        val rankCounts = mapOf(
            Rank.FIFTH to 3,
            Rank.FOURTH to 1,
            Rank.THIRD to 0,
            Rank.SECOND to 0,
            Rank.FIRST to 0,
        )
        val purchaseAmount = 5000 * 4
        val result = Result(rankCounts, purchaseAmount)

        val profitRate = result.profitRate()

        val expectedTotalPrize = 15_000L + 50_000L
        val expectedProfitRate = (expectedTotalPrize.toDouble() / 20_000) * 100

        assertThat(profitRate).isEqualTo(expectedProfitRate)
    }

    @Test
    fun `calculates profit rate as 0 when there are no winning tickets`() {
        val rankCounts = mapOf(
            Rank.FIFTH to 0,
            Rank.FOURTH to 0,
            Rank.THIRD to 0,
            Rank.SECOND to 0,
            Rank.FIRST to 0,
        )
        val purchaseAmount = 10_000
        val result = Result(rankCounts, purchaseAmount)

        val profitRate = result.profitRate()

        assertThat(profitRate).isEqualTo(0.0)
    }

    @Test
    fun `calculates profit rate when winning first prize`() {
        val rankCounts = mapOf(
            Rank.FIRST to 1,  // 2,000,000,000
            Rank.SECOND to 0,
            Rank.THIRD to 0,
            Rank.FOURTH to 0,
            Rank.FIFTH to 0,
        )
        val purchaseAmount = 10_000
        val result = Result(rankCounts, purchaseAmount)

        val profitRate = result.profitRate()

        val expectedProfitRate = (2_000_000_000.0 / 10_000) * 100
        assertThat(profitRate).isEqualTo(expectedProfitRate)
    }
}
