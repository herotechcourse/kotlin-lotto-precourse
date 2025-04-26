package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoProfitCalculatorTest {

    @Test
    fun `calculate returns correct profit rate when prizes exist`() {
        // given
        val results = LottoResults(
            listOf(
                LottoMatchResult(6, false),
                LottoMatchResult(5, true),
                LottoMatchResult(5, false),
                LottoMatchResult(4, false),
                LottoMatchResult(3, false)
            )
        )
        val purchaseAmount = 5000

        // when
        val calculator = LottoProfitCalculator(results, purchaseAmount)
        val profitRate = calculator.calculate()

        // then
        val expectedReward =
            Prize.FIRST.amount +
                    Prize.SECOND.amount +
                    Prize.THIRD.amount +
                    Prize.FOURTH.amount +
                    Prize.FIFTH.amount

        val expectedProfitRate = expectedReward.toDouble() / purchaseAmount

        assertThat(profitRate.value()).isEqualTo(expectedProfitRate)
    }

    @Test
    fun `calculate returns zero profit rate when there are no winnings`() {
        // given
        val results = LottoResults(
            listOf(
                LottoMatchResult(0, false),
                LottoMatchResult(1, false),
                LottoMatchResult(2, false)
            )
        )
        val purchaseAmount = 3000

        // when
        val calculator = LottoProfitCalculator(results, purchaseAmount)
        val profitRate = calculator.calculate()

        // then
        assertThat(profitRate.value()).isEqualTo(0.0)
    }
}
