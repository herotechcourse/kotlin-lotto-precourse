package lotto.view

import lotto.model.MATCH

object OutputView {
    private const val WINNING_STATISTICS_START_MESSAGE_OUTPUT = "Winning Statistics"
    private const val SEPARATOR_LINE_OUTPUT = "---"

    private const val THREE_MATCH_PRIZE = "5,000 KRW"
    private const val FOUR_MATCH_PRIZE = "5,0000 KRW"
    private const val FIVE_MATCH_PRIZE = "1,500,000 KRW"
    private const val FIVE_AND_BONUS_MATCH_PRIZE = "30,000,000 KRW"
    private const val SIX_MATCH_PRIZE = "2,000,000,000 KRW"

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
        println("3 Matches ($THREE_MATCH_PRIZE) – ${MATCH.THREE} tickets")
        println("4 Matches ($FOUR_MATCH_PRIZE) – ${MATCH.FOUR} tickets")
        println("5 Matches ($FIVE_MATCH_PRIZE) – ${MATCH.FIVE} tickets")
        println("5 Matches + Bonus Ball ($FIVE_AND_BONUS_MATCH_PRIZE) – ${MATCH.FIVE_AND_BONUS} tickets")
        println("6 Matches ($SIX_MATCH_PRIZE) – ${MATCH.SIX} tickets")
    }

    fun printReturnRate(returnRate: Number) {
        println("Total return rate is $returnRate%.")
    }
}
