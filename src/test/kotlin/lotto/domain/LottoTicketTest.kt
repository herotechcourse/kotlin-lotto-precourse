package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import lotto.Lotto


class LottoTicketTest {

    @Test
    fun `3개 번호가 일치하면 5등이다`() {
        val lottoTicket = LottoTicket(Lotto(listOf(1, 2, 3, 5, 6, 7)))
        val winningNumbers = listOf(1, 2, 3, 20, 21, 22)
        val bonusNumber = 7

        val rank = lottoTicket.match(winningNumbers, bonusNumber)

        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `6개 번호가 일치하면 1등이다`() {
        val lottoTicket = LottoTicket(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val rank = lottoTicket.match(winningNumbers, bonusNumber)

        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `5개 번호와 보너스 번호가 일치하면 2등이다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lottoTicket = LottoTicket(Lotto(listOf(1, 2, 3, 5, 6, 7)))

        val rank = lottoTicket.match(winningNumbers, bonusNumber)

        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `5개 번호만 일치하고 보너스 번호 불일치하면 3등이다`() {
        val lottoTicket = LottoTicket(Lotto(listOf(1, 2, 3, 4, 5, 8)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val rank = lottoTicket.match(winningNumbers, bonusNumber)

        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `4개 번호가 일치하면 4등이다`() {
        val lottoTicket = LottoTicket(Lotto(listOf(1, 2, 3, 4, 10, 11)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val rank = lottoTicket.match(winningNumbers, bonusNumber)

        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `2개 이하 번호가 일치하면 당첨되지 않는다`() {
        val lottoTicket = LottoTicket(Lotto(listOf(1, 10, 11, 12, 13, 14)))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val rank = lottoTicket.match(winningNumbers, bonusNumber)

        assertThat(rank).isEqualTo(Rank.NONE)
    }
}
