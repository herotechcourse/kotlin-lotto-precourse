package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultCalculatorTest {

    private val resultCalculator = ResultCalculator()

    @Test
    fun `calculates correct results when tickets match winning numbers`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 matches → 1st prize
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 + bonus → 2nd prize
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 matches → 3rd prize
            Lotto(listOf(1, 2, 3, 4, 8, 9)), // 4 matches → 4th prize
            Lotto(listOf(1, 2, 3, 8, 9, 10)), // 3 matches → 5th prize
            Lotto(listOf(1, 2, 8, 9, 10, 11)) // 2 matches → No prize
        )

        val results = resultCalculator.calculateResults(tickets, winningNumbers)

        assertThat(results[Rank.FIRST]).isEqualTo(1)
        assertThat(results[Rank.SECOND]).isEqualTo(1)
        assertThat(results[Rank.THIRD]).isEqualTo(1)
        assertThat(results[Rank.FOURTH]).isEqualTo(1)
        assertThat(results[Rank.FIFTH]).isEqualTo(1)
        assertThat(results.size).isEqualTo(5) // Only 5 ranks, no others
    }

    @Test
    fun `calculates correct profit rate`() {
        val results = mapOf(
            Rank.FIRST to 0,
            Rank.SECOND to 1, // 30,000,000 KRW
            Rank.THIRD to 1,  // 1,500,000 KRW
            Rank.FOURTH to 1, // 50,000 KRW
            Rank.FIFTH to 1   // 5,000 KRW
        )
        val purchaseAmount = 5000 * 10 // 10 tickets → 50,000 KRW

        val profitRate = resultCalculator.calculateProfitRate(results, purchaseAmount)

        // Total Winnings = 30,000,000 + 1,500,000 + 50,000 + 5,000 = 31,555,000 KRW
        // Profit Rate = (31,555,000 / 50,000) * 100 = 63,110.0 %
        assertThat(profitRate).isEqualTo(63110.0)
    }
}
