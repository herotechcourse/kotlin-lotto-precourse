package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultCalculatorTest {
    @Test
    fun `calculateStats returns correct counts for each rank`() {
        // given
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonus = BonusNumber(7)
        val calculator = LottoResultCalculator(winning, bonus)

        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),    // FIRST
            Lotto(listOf(1, 2, 3, 4, 5, 7)),    // SECOND (5 matches + bonus)
            Lotto(listOf(1, 2, 3, 4, 5, 8)),    // THIRD (5 matches)
            Lotto(listOf(1, 2, 3, 4, 8, 9)),    // FOURTH (4 matches)
            Lotto(listOf(1, 2, 3, 8, 9, 10)),    // FIFTH (3 matches)
            Lotto(listOf(7, 8, 9, 10, 11, 12))  // MISS
        )

        // when
        val stats = calculator.calculateStats(lottos)

        // then
        assertThat(stats).hasSize(Rank.entries.size)
        assertThat(stats[Rank.FIRST]).isEqualTo(1)
        assertThat(stats[Rank.SECOND]).isEqualTo(1)
        assertThat(stats[Rank.THIRD]).isEqualTo(1)
        assertThat(stats[Rank.FOURTH]).isEqualTo(1)
        assertThat(stats[Rank.FIFTH]).isEqualTo(1)
    }
}
