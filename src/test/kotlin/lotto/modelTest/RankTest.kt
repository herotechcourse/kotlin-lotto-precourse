package lotto.modelTest

import lotto.Lotto
import lotto.model.LottoService
import lotto.model.Rank
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RankTest {

    @Test
    fun `all tickets match the same prize`() {

        val lottoService = LottoService()

        lottoService.setWinnerNumbers(listOf(1, 2, 3, 4, 5, 6))
        lottoService.setBonusNumber(7)

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 5, 9)),
            Lotto(listOf(1, 2, 3, 4, 5, 10))
        )
        lottoService.setTickets(tickets)

        val rankCounts = lottoService.compareTickets()

        assertThat(rankCounts[Rank.FIRST]).isEqualTo(0)
        assertThat(rankCounts[Rank.SECOND]).isEqualTo(0)
        assertThat(rankCounts[Rank.THIRD]).isEqualTo(3)
        assertThat(rankCounts[Rank.FOURTH]).isEqualTo(0)
        assertThat(rankCounts[Rank.FIFTH]).isEqualTo(0)
        assertThat(rankCounts[Rank.NONE]).isEqualTo(0)
    }

    @Test
    fun `some tickets match fifth prize`() {

        val lottoService = LottoService()

        lottoService.setWinnerNumbers(listOf(1, 2, 3, 4, 5, 6))
        lottoService.setBonusNumber(7)

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 10, 11, 12)),
            Lotto(listOf(4, 5, 6, 10, 11, 12)),
            Lotto(listOf(31, 32, 33, 34, 35, 38))
        )
        lottoService.setTickets(tickets)

        val rankCounts = lottoService.compareTickets()

        assertThat(rankCounts[Rank.FIRST]).isEqualTo(0)
        assertThat(rankCounts[Rank.SECOND]).isEqualTo(0)
        assertThat(rankCounts[Rank.THIRD]).isEqualTo(0)
        assertThat(rankCounts[Rank.FOURTH]).isEqualTo(0)
        assertThat(rankCounts[Rank.FIFTH]).isEqualTo(2)
        assertThat(rankCounts[Rank.NONE]).isEqualTo(1)
    }

    @Test
    fun `no tickets match`() {

        val lottoService = LottoService()

        lottoService.setWinnerNumbers(listOf(1, 2, 3, 4, 5, 6))
        lottoService.setBonusNumber(7)

        val tickets = listOf(
            Lotto(listOf(10, 11, 12, 13, 14, 15)),
            Lotto(listOf(16, 17, 18, 19, 20, 21))
        )
        lottoService.setTickets(tickets)

        val rankCounts = lottoService.compareTickets()

        assertThat(rankCounts[Rank.FIRST]).isEqualTo(0)
        assertThat(rankCounts[Rank.SECOND]).isEqualTo(0)
        assertThat(rankCounts[Rank.THIRD]).isEqualTo(0)
        assertThat(rankCounts[Rank.FOURTH]).isEqualTo(0)
        assertThat(rankCounts[Rank.FIFTH]).isEqualTo(0)
        assertThat(rankCounts[Rank.NONE]).isEqualTo(2)
    }

    @Test
    fun `tickets match different ranks`() {

        val lottoService = LottoService()

        lottoService.setWinnerNumbers(listOf(1, 2, 3, 4, 5, 6))
        lottoService.setBonusNumber(7)

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8))
        )
        lottoService.setTickets(tickets)

        val rankCounts = lottoService.compareTickets()

        assertThat(rankCounts[Rank.FIRST]).isEqualTo(1)
        assertThat(rankCounts[Rank.SECOND]).isEqualTo(1)
        assertThat(rankCounts[Rank.THIRD]).isEqualTo(1)
        assertThat(rankCounts[Rank.FOURTH]).isEqualTo(0)
        assertThat(rankCounts[Rank.FIFTH]).isEqualTo(0)
        assertThat(rankCounts[Rank.NONE]).isEqualTo(0)
    }
}