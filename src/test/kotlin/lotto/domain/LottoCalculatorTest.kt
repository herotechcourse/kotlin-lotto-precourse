package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoCalculatorTest {
    @Test
    fun `calculate ranks and profit rate correctly`() {
        // given
        val winningNumbers = WinningNumbers.of(listOf(1,2,3,4,5,6))
        val bonusNumber = LottoNumber(7)

        val tickets = listOf(
            Lotto.from(listOf(1,2,3,4,5,6)), // 1st
            Lotto.from(listOf(1,2,3,4,5,7)), // 2nd
            Lotto.from(listOf(1,2,3,4,5,10)), // 3rd
            Lotto.from(listOf(1,2,3,4,10,11)), // 4th
            Lotto.from(listOf(1,2,3,10,11,12)), // 5th
        )

        // when
        val calculator = LottoCalculator(winningNumbers, bonusNumber, tickets)

        // then
        assertThat(calculator.getResult().lottoRanks).containsExactlyInAnyOrderEntriesOf(
            mapOf(
                Rank.FIRST to 1,
                Rank.SECOND to 1,
                Rank.THIRD to 1,
                Rank.FOURTH to 1,
                Rank.FIFTH to 1
            )
        )

        // Paid: 5 tickets * 1000 = 5000
        // Profit: 2000000000 + 30000000 + 1500000 + 50000 + 5000
        val expectedProfit = 2000000000L + 30000000L + 1500000L + 50000L + 5000L
        val expectedProfitRate = expectedProfit.toDouble() / 5000 * 100

        assertThat(calculator.getResult().profitRate).isEqualTo(expectedProfitRate)
    }
}
