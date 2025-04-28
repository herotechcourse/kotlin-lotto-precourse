package lotto

import lotto.domain.LottoResult
import lotto.domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `calculates correct ranks and profit rate`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 10, 11)),
            Lotto(listOf(1, 2, 3, 10, 11, 12)),
            Lotto(listOf(10, 11, 12, 13, 14, 15))
        )

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoResult.of(tickets, winningNumbers, bonusNumber)
        val results = result.getResults()

        assertThat(results[Rank.FIRST]).isEqualTo(1)
        assertThat(results[Rank.SECOND]).isEqualTo(1)
        assertThat(results[Rank.THIRD]).isEqualTo(1)
        assertThat(results[Rank.FOURTH]).isEqualTo(1)
        assertThat(results[Rank.FIFTH]).isEqualTo(1)
        assertThat(results[Rank.NONE]).isEqualTo(1)

        val expectedTotalPrize =
            2_000_000_000 + 30_000_000 + 1_500_000 + 50_000 + 5_000

        val expectedProfitRate = String.format("%.1f", expectedTotalPrize.toDouble() / 6000 * 100)

        assertThat(result.profitRate(6000)).isEqualTo(expectedProfitRate)
    }
}
