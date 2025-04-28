package lotto.view

import lotto.model.LottoRank
import lotto.model.Match
import java.text.DecimalFormat

object OutputView {
    private const val WINNING_STATISTICS_START_MESSAGE_OUTPUT = "Winning Statistics"
    private const val SEPARATOR_LINE_OUTPUT = "---"

    private const val CURRENCY_UNIT = "KRW"

    fun printTicketCount(ticketCount: Int) {
        println()
        println("You have purchased $ticketCount tickets.")
    }

    fun printWinningStatisticsStartLine() {
        println()
        println(WINNING_STATISTICS_START_MESSAGE_OUTPUT)
        println(SEPARATOR_LINE_OUTPUT)
    }

    fun printWinningStatistics() {
        LottoRank.entries.forEach { rank ->
            println("${rank.comment} (${splitComma(rank.prize)} $CURRENCY_UNIT) – ${matchCountOf(rank)} tickets")
        }
    }

    fun printReturnRate(returnRate: Number) {
        println("Total return rate is $returnRate%.")
    }

    private fun splitComma(amount: Int): String {
        return DecimalFormat("#,###").format(amount)
    }

    private fun matchCountOf(rank: LottoRank): Int {
        return when (rank) {
            LottoRank.FIFTH -> Match.threeCount
            LottoRank.FOURTH -> Match.fourCount
            LottoRank.THIRD -> Match.fiveCount
            LottoRank.SECOND -> Match.fiveAndBonusCount
            LottoRank.FIRST -> Match.sixCount
        }
    }
}
