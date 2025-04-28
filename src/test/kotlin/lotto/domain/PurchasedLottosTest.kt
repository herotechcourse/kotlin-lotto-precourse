package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class PurchasedLottosTest {
    private val tickets = listOf(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        Lotto(listOf(7, 8, 9, 10, 11, 12))
    )

    @Test
    fun `count returns the number of lotto tickets`() {
        val purchasedLottos = PurchasedLottos(tickets)
        assertThat(purchasedLottos.count()).isEqualTo(2)
    }

    @Test
    fun `getAllTickets returns a new list with the same tickets`() {
        val purchasedLottos = PurchasedLottos(tickets)
        val allTickets = purchasedLottos.getAllTickets()

        assertThat(allTickets).isEqualTo(tickets)
        assertThat(allTickets).isNotSameAs(tickets)
    }

    @Test
    fun `calculateWinningStats returns correct stats`() {
        val testTickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(2, 3, 4, 5, 6, 7)),
            Lotto(listOf(2, 3, 4, 5, 6, 8)),
            Lotto(listOf(3, 4, 5, 6, 7, 8)),
            Lotto(listOf(4, 5, 6, 7, 8, 9)),
            Lotto(listOf(5, 6, 7, 8, 9, 10))
        )
        val purchasedLottos = PurchasedLottos(testTickets)
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val stats = purchasedLottos.calculateWinningStats(winningLotto,bonusNumber)

        assertThat(stats.stats[WinningRank.FIRST]).isEqualTo(1)
        assertThat(stats.stats[WinningRank.SECOND]).isEqualTo(1)
        assertThat(stats.stats[WinningRank.THIRD]).isEqualTo(1)
        assertThat(stats.stats[WinningRank.FOURTH]).isEqualTo(1)
        assertThat(stats.stats[WinningRank.FIFTH]).isEqualTo(1)
        assertThat(stats.stats[WinningRank.MISS]).isEqualTo(1)
    }
}