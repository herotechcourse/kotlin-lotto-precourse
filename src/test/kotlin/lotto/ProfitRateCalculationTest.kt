package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ProfitRateCalculationTest {

    @Test
    fun `profit rate is calculated correctly`() {
        val prizeRanks = listOf(
            PrizeRank.FIRST,
            PrizeRank.SECOND,
            PrizeRank.THIRD,
            PrizeRank.FOURTH,
            PrizeRank.FIFTH,
            null
        )

        val purchaseAmount = 6000 // 6 tickets x 1000 KRW
        val profitRate = calculateProfitRate(prizeRanks, purchaseAmount)

        val expectedWinnings = 2_000_000_000 + 30_000_000 + 1_500_000 + 50_000 + 5_000
        val expectedProfitRate = (expectedWinnings.toFloat() / purchaseAmount) * 100

        assertThat(profitRate).isEqualTo(expectedProfitRate)
    }

    @Test
    fun `profit rate is zero when purchase amount is zero`() {
        val profitRate = calculateProfitRate(emptyList(), 0)
        assertThat(profitRate).isEqualTo(0f)
    }
}
