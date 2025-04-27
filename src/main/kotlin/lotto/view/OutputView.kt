package lotto.view

import lotto.model.*
import java.text.DecimalFormat

object OutputView {
    private const val WINNING_STATISTICS_START_MESSAGE_OUTPUT = "Winning Statistics"
    private const val SEPARATOR_LINE_OUTPUT = "---"

    private const val CURRENCY_UNIT = "KRW"

    private fun splitComma(amount: Int): String {
        return DecimalFormat("#,###").format(amount)
    }

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
        println("3 Matches (${splitComma(FIFTH_PRIZE)} $CURRENCY_UNIT) – ${MATCH.THREE} tickets")
        println("4 Matches (${splitComma(FOURTH_PRIZE)} $CURRENCY_UNIT) – ${MATCH.FOUR} tickets")
        println("5 Matches (${splitComma(THIRD_PRIZE)} $CURRENCY_UNIT) – ${MATCH.FIVE} tickets")
        println("5 Matches + Bonus Ball (${splitComma(SECOND_PRIZE)} $CURRENCY_UNIT) – ${MATCH.FIVE_AND_BONUS} tickets")
        println("6 Matches (${splitComma(FIRST_PRIZE)} $CURRENCY_UNIT) – ${MATCH.SIX} tickets")
    }

    fun printReturnRate(returnRate: Number) {
        println("Total return rate is $returnRate%.")
    }
}
