package lotto

import lotto.domain.PrizeRank
import lotto.service.ProfitCaculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {
    @Test
    fun `should correctly calculate profit rate based on total purchase and winnings`() {
        // given
        val prizeResult = mapOf(
            PrizeRank.FIRST to 1,
            PrizeRank.SECOND to 0,
            PrizeRank.THIRD to 0,
            PrizeRank.FOURTH to 0,
            PrizeRank.FIFTH to 0
        )
        val purchaseAmount = 1

        // when
        val profitRate = ProfitCaculator.calculate(prizeResult, purchaseAmount)

        // then
        assertThat(profitRate).isEqualTo("200000000.0")
    }

    @Test
    fun `should round profit rate correctly when it includes decimal places`() {
        // given
        val prizeResult = mapOf(
            PrizeRank.FIFTH to 1
        )
        val purchaseAmount = 2

        // when
        val profitRate = ProfitCaculator.calculate(prizeResult, purchaseAmount)

        // then
        assertThat(profitRate).isEqualTo("250.0")
    }
}