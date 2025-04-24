package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PriceCalculatorTest {
    @MethodSource("returnRateTestData")
    @ParameterizedTest
    fun `price calculator can calculate the return rate`(
        purchaseAmount: Int,
        countOfRanks: Map<Rank, Int>,
        returnRate: Float,
    ) {
        // given
        val priceCalculator = PriceCalculator()

        // when
        val actual = priceCalculator.calculateReturnRate(purchaseAmount, countOfRanks)

        // then
        assertThat(actual).isEqualTo(returnRate)
    }

    companion object {
        @JvmStatic
        fun returnRateTestData(): List<Arguments> = listOf(
            Arguments.of(
                1000,
                mapOf(Rank.FIRST to 0, Rank.SECOND to 0, Rank.THIRD to 0, Rank.FOURTH to 0, Rank.FIFTH to 1),
                500f,
            ),
            Arguments.of(
                5000,
                mapOf(Rank.FIRST to 0, Rank.SECOND to 0, Rank.THIRD to 0, Rank.FOURTH to 1, Rank.FIFTH to 0),
                1000f,
            ),
            Arguments.of(
                10000,
                mapOf(Rank.FIRST to 0, Rank.SECOND to 1, Rank.THIRD to 0, Rank.FOURTH to 0, Rank.FIFTH to 0),
                300000f,
            )

        )
    }
}
