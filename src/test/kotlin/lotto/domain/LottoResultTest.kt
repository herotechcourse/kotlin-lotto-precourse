package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `calculates rank counts, total prize, and yield correctly`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),    // FIRST
            Lotto(listOf(1, 2, 3, 4, 5, 7)),    // SECOND (5 + bonus)
            Lotto(listOf(1, 2, 3, 4, 5, 8)),    // THIRD
            Lotto(listOf(1, 2, 3, 4, 8, 9)),    // FOURTH
            Lotto(listOf(1, 2, 3, 10, 11, 12)), // FIFTH
            Lotto(listOf(1, 2, 10, 11, 12, 13)) // MISS
        )
        val winningNumbers = WinningNumbers.of(listOf(1, 2, 3, 4, 5, 6), 7)
        val result = LottoResult(tickets, winningNumbers)

        val counts = result.getRankCounts()
        assertThat(counts[Rank.FIRST]).isEqualTo(1)
        assertThat(counts[Rank.SECOND]).isEqualTo(1)
        assertThat(counts[Rank.THIRD]).isEqualTo(1)
        assertThat(counts[Rank.FOURTH]).isEqualTo(1)
        assertThat(counts[Rank.FIFTH]).isEqualTo(1)
        assertThat(counts[Rank.MISS]).isEqualTo(1)

        val expectedPrize = Rank.FIRST.prize + Rank.SECOND.prize + Rank.THIRD.prize +
                Rank.FOURTH.prize + Rank.FIFTH.prize
        assertThat(result.getTotalPrize()).isEqualTo(expectedPrize)

        val money = Money(tickets.size * 1000)
        val expectedYield = String.format("%.1f", expectedPrize.toDouble() * 100 / money.amount).toDouble()
        assertThat(result.calculateYield(money)).isEqualTo(expectedYield)
    }
}
