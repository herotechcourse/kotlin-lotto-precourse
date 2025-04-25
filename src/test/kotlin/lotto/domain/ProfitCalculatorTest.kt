package lotto.domain

import lotto.domain.ProfitCalculator
import lotto.domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    @Test
    fun `calculate profit rate based on statistics and purchase amount`() {
        // given
        val statistics = mapOf(
            Rank.FIFTH to 1,      // 3 Matches – 5,000 KRW
            Rank.FOURTH to 0,     // 4 Matches
            Rank.THIRD to 0,      // 5 Matches
            Rank.SECOND to 0,     // 5 Matches + Bonus
            Rank.FIRST to 0,      // 6 Matches
            Rank.NONE to 0        // No matches
        )
        val purchaseAmount = 8_000

        // when
        val profitRate = ProfitCalculator.calculate(statistics, purchaseAmount)

        // then
        assertThat(profitRate).isEqualTo(62.5)
    }
}
