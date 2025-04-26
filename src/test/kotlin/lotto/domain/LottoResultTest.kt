package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `calculates rank counts correctly`() {
        // Create winning numbers
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        
        // Create tickets with different ranks
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),  // First rank
            Lotto(listOf(1, 2, 3, 4, 5, 7)),  // Second rank
            Lotto(listOf(1, 2, 3, 4, 5, 8)),  // Third rank
            Lotto(listOf(1, 2, 3, 4, 8, 9)),  // Fourth rank
            Lotto(listOf(1, 2, 3, 8, 9, 10)), // Fifth rank
            Lotto(listOf(1, 2, 8, 9, 10, 11)) // None
        )
        
        val result = LottoResult(tickets, winningNumbers)
        val rankCounts = result.getRankCounts()
        
        assertThat(rankCounts[Rank.FIRST]).isEqualTo(1)
        assertThat(rankCounts[Rank.SECOND]).isEqualTo(1)
        assertThat(rankCounts[Rank.THIRD]).isEqualTo(1)
        assertThat(rankCounts[Rank.FOURTH]).isEqualTo(1)
        assertThat(rankCounts[Rank.FIFTH]).isEqualTo(1)
    }

    @Test
    fun `calculates total prize correctly`() {
        // Create winning numbers
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        
        // Create tickets with different ranks
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),  // First rank: 2,000,000,000
            Lotto(listOf(1, 2, 3, 4, 5, 7)),  // Second rank: 30,000,000
            Lotto(listOf(1, 2, 3, 4, 5, 8))   // Third rank: 1,500,000
        )
        
        val result = LottoResult(tickets, winningNumbers)
        val totalPrize = result.getTotalPrize()
        
        // 2,000,000,000 + 30,000,000 + 1,500,000 = 2,031,500,000
        assertThat(totalPrize).isEqualTo(2_031_500_000)
    }

    @Test
    fun `calculates profit rate correctly`() {
        // Create winning numbers
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        
        // Create tickets with one fifth rank win (5,000 prize)
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 8, 9, 10))  // Fifth rank: 5,000
        )
        
        val result = LottoResult(tickets, winningNumbers)
        
        // Profit rate = (5,000 / 1,000) * 100 = 500.0%
        assertThat(result.getFormattedProfitRate()).isEqualTo("500.0")
    }

    @Test
    fun `formats profit rate correctly`() {
        // Create winning numbers
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        
        // Create 8 tickets with one fifth rank win (5,000 prize)
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 8, 9, 10)),  // Fifth rank: 5,000
            Lotto(listOf(1, 2, 8, 9, 10, 11)),
            Lotto(listOf(1, 8, 9, 10, 11, 12)),
            Lotto(listOf(8, 9, 10, 11, 12, 13)),
            Lotto(listOf(14, 15, 16, 17, 18, 19)),
            Lotto(listOf(20, 21, 22, 23, 24, 25)),
            Lotto(listOf(26, 27, 28, 29, 30, 31)),
            Lotto(listOf(32, 33, 34, 35, 36, 37))
        )
        
        val result = LottoResult(tickets, winningNumbers)
        
        // Profit rate = (5,000 / 8,000) * 100 = 62.5%
        assertThat(result.getFormattedProfitRate()).isEqualTo("62.5")
    }
}
