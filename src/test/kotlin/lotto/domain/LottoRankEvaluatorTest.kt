package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankEvaluatorTest {

    private val winningNumbers = WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6))
    private val bonusNumber = BonusNumber(LottoNumber(7), winningNumbers)

    @Test
    fun `returns correct statistics for multiple lotto tickets`() {
        // given
        val tickets = listOf(
            Lotto.of(listOf(1, 2, 3, 4, 5, 6)), // 6 match → 1st
            Lotto.of(listOf(1, 2, 3, 4, 5, 7)), // 5 + bonus → 2nd
            Lotto.of(listOf(1, 2, 3, 4, 5, 8)), // 5 match → 3rd
            Lotto.of(listOf(1, 2, 3, 4, 8, 9)), // 4 match → 4th
            Lotto.of(listOf(1, 2, 3, 8, 9, 10)), // 3 match → 5th
            Lotto.of(listOf(1, 2, 8, 9, 10, 11)) // 2 match → none
        )
        val lottoTickets = LottoTickets(tickets)

        // when
        val result: Map<Rank, Int> = LottoRankEvaluator.evaluate(lottoTickets, winningNumbers, bonusNumber)

        // then
        assertThat(result[Rank.FIRST]).isEqualTo(1)
        assertThat(result[Rank.SECOND]).isEqualTo(1)
        assertThat(result[Rank.THIRD]).isEqualTo(1)
        assertThat(result[Rank.FOURTH]).isEqualTo(1)
        assertThat(result[Rank.FIFTH]).isEqualTo(1)
        assertThat(result[Rank.NONE]).isEqualTo(1)
    }
}