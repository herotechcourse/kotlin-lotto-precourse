package lotto.service

import lotto.Lotto
import lotto.domain.LottoTickets
import lotto.domain.Rank
import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {

    @Test
    fun `evaluates tickets and returns correct rank counts`() {
        val tickets = LottoTickets.of(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 45)),
            Lotto(listOf(1, 2, 3, 4, 44, 45)),
            Lotto(listOf(1, 2, 3, 43, 44, 45)),
            Lotto(listOf(10, 20, 30, 40, 41, 42))
        )

        val winning = WinningNumbers(
            listOf(1, 2, 3, 4, 5, 6),
            bonusNumber = 7
        )

        val result = LottoGame(tickets, winning).evaluate()

        assertThat(result[Rank.FIRST]).isEqualTo(1)
        assertThat(result[Rank.SECOND]).isEqualTo(1)
        assertThat(result[Rank.THIRD]).isEqualTo(1)
        assertThat(result[Rank.FOURTH]).isEqualTo(1)
        assertThat(result[Rank.FIFTH]).isEqualTo(1)
        assertThat(result.size).isEqualTo(5)
    }

    @Test
    fun `returns empty map if no tickets win`() {
        val tickets = LottoTickets.of(
            Lotto(listOf(10, 20, 30, 31, 32, 33)),
            Lotto(listOf(40, 41, 42, 43, 44, 45))
        )

        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        val result = LottoGame(tickets, winning).evaluate()

        assertThat(result).isEmpty()
    }
}