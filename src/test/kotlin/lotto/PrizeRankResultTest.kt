package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PrizeRankResultTest {

    @ParameterizedTest
    @MethodSource("provideRankAndProfitRate")
    fun `should calculate profit rate`(statistics: Map<PrizeRank, Int>, expectedProfitRate: Double) {
        // given
        val prizeRankResult = PrizeRankResult(statistics)
        val purchaseAmount = LottoPurchaseAmount(statistics.values.sumOf { it * TICKET_PRICE })
        // when
        val profitRate = prizeRankResult.calculateProfitRate(purchaseAmount)
        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate)
    }

    companion object {
        private const val TICKET_PRICE: Int = 1000

        @JvmStatic
        fun provideRankAndProfitRate() = listOf(
            arrayOf(
                mapOf(
                    PrizeRank.SECOND to 1,
                    PrizeRank.NONE to 4,
                ),
                600000.0
            ),
            arrayOf(
                mapOf(
                    PrizeRank.SECOND to 1,
                    PrizeRank.FOURTH to 5,
                    PrizeRank.NONE to 4,
                ),
                302500.0
            ),
            arrayOf(
                mapOf(
                    PrizeRank.NONE to 6,
                ),
                0.0
            )
        )
    }
}


