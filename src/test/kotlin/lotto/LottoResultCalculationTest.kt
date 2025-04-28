package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultCalculatorTest {
    private val calculator = LottoResultCalculator()

    @Test
    fun `calculate winning tickets`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 matching
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 5 matching + bonus
            Lotto(listOf(1, 2, 3, 4, 5, 8)), // 5 matching
            Lotto(listOf(1, 2, 3, 4, 7, 8)), // 4 matching
            Lotto(listOf(1, 2, 3, 7, 8, 9))  // 3 matching
        )
        val result = calculator.calculate(tickets, listOf(1, 2, 3, 4, 5, 6), 7)

        assertThat(result.winners[Rank.SIX_MATCHES]).isEqualTo(1)
        assertThat(result.winners[Rank.FIVE_MATCHES_WITH_BONUS]).isEqualTo(1)
        assertThat(result.winners[Rank.FIVE_MATCHES]).isEqualTo(1)
        assertThat(result.winners[Rank.FOUR_MATCHES]).isEqualTo(1)
        assertThat(result.winners[Rank.THREE_MATCHES]).isEqualTo(1)
    }

    @Test
    fun `calculate no winning tickets`() {
        val tickets = listOf(
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )
        val result = calculator.calculate(tickets, listOf(1, 2, 3, 4, 5, 6), 7)

        assertThat(result.winners).isEmpty()
        assertThat(result.profitRate).isEqualTo(0.0)
    }

    @Test
    fun `calculate profit rate`() {
        val tickets = listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(13, 14, 16, 38, 42, 45)),
            Lotto(listOf(7, 11, 30, 40, 42, 43)),
            Lotto(listOf(2, 13, 22, 32, 38, 45)),
            Lotto(listOf(1, 3, 5, 14, 22, 45))  // 3 matches
        )
        val result = calculator.calculate(tickets, listOf(1, 2, 3, 4, 5, 6), 7)

        assertThat(result.winners[Rank.THREE_MATCHES]).isEqualTo(1)
        assertThat(result.profitRate).isEqualTo(62.5)
    }
}
