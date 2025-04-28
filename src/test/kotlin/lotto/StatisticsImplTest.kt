package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StatisticsImplTest {

    private val statistics: Statistics = StatisticsImpl()

    @Test
    fun `calculateResult returns correct rank counts`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 8, 9)),
            Lotto(listOf(1, 2, 3, 8, 9, 10)),
            Lotto(listOf(1, 2, 8, 9, 10, 11)),
        )

        val result = statistics.calculateResult(tickets, winningNumbers, bonusNumber)

        assertThat(result[Rank.FIRST]).isEqualTo(1)
        assertThat(result[Rank.SECOND]).isEqualTo(1)
        assertThat(result[Rank.THIRD]).isEqualTo(1)
        assertThat(result[Rank.FOURTH]).isEqualTo(1)
        assertThat(result[Rank.FIFTH]).isEqualTo(1)
        assertThat(result[Rank.NONE]).isNull()
    }

    @Test
    fun `calculateProfitRate returns correct profit rate`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
        )
        statistics.calculateResult(tickets, winningNumbers, bonusNumber)
        val purchaseAmount = 2000
        val expectedTotalPrize = Rank.FIRST.prize + Rank.SECOND.prize
        val expectedProfitRate = (expectedTotalPrize.toDouble() / purchaseAmount) * 100

        val profitRate = statistics.calculateProfitRate(purchaseAmount)

        assertThat(profitRate).isEqualTo(expectedProfitRate)
    }
}
