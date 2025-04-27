package lotto.ui

import lotto.Lotto
import lotto.domain.PurchasedLottos
import lotto.domain.WinningRank
import lotto.domain.WinningStats
import lotto.util.Constants
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest {

    @Test
    fun `printPurchasedLottos test`() {
        val testIO = TestConsoleIO()
        val outputView = OutputView(testIO)
        val purchasedLottos = PurchasedLottos(
            listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(7, 8, 9, 10, 11, 12)))
        )
        outputView.printPurchasedLottos(purchasedLottos)
        assertThat(testIO.outputMessages[0]).isEqualTo("\nYou have purchased 2 tickets.")
        assertThat(testIO.outputMessages[1]).isEqualTo("[1, 2, 3, 4, 5, 6]")
        assertThat(testIO.outputMessages[2]).isEqualTo("[7, 8, 9, 10, 11, 12]")
    }

    @Test
    fun `printWinningStats test`() {
        val testIO = TestConsoleIO()
        val outputView = OutputView(testIO)
        val winningStats = WinningStats(
            mapOf(
                WinningRank.FIFTH to 5,
                WinningRank.FOURTH to 4,
                WinningRank.THIRD to 3,
                WinningRank.SECOND to 2,
                WinningRank.FIRST to 1,
            )
        )
        outputView.printWinningStats(winningStats)

        assertThat(testIO.outputMessages[0]).isEqualTo("\nWinning Statistics")
        assertThat(testIO.outputMessages[1]).isEqualTo("---")
        assertThat(testIO.outputMessages[2]).isEqualTo(
            "3 Matches (${Constants.FORMATTED_PRIZE_FIFTH} ${Constants.CURRENCY_UNIT}) – 5 tickets"
        )
        assertThat(testIO.outputMessages[3]).isEqualTo(
            "4 Matches (${Constants.FORMATTED_PRIZE_FOURTH} ${Constants.CURRENCY_UNIT}) – 4 tickets"
        )
        assertThat(testIO.outputMessages[4]).isEqualTo(
            "5 Matches (${Constants.FORMATTED_PRIZE_THIRD} ${Constants.CURRENCY_UNIT}) – 3 tickets"
        )
        assertThat(testIO.outputMessages[5]).isEqualTo(
            "5 Matches + Bonus Ball (${Constants.FORMATTED_PRIZE_SECOND} ${Constants.CURRENCY_UNIT}) – 2 tickets"
        )
        assertThat(testIO.outputMessages[6]).isEqualTo(
            "6 Matches (${Constants.FORMATTED_PRIZE_FIRST} ${Constants.CURRENCY_UNIT}) – 1 tickets"
        )
    }

    @Test
    fun `printProfitRate test`() {
        val testIO = TestConsoleIO()
        val outputView = OutputView(testIO)
        val winningStats = WinningStats(
            mapOf(
                WinningRank.FIFTH to 2,
                WinningRank.FOURTH to 3
            )
        )
        val purchaseAmount = 10000
        outputView.printProfitRate(winningStats, purchaseAmount)
        assertThat(testIO.outputMessages[0]).isEqualTo("Total return rate is 1600.0%.")
    }
}