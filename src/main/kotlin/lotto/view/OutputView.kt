package lotto.view

import lotto.model.MATCH

object OutputView {
    fun printTicketCount(ticketCount: Int) {
        println()
        println("You have purchased $ticketCount tickets.")
    }

    fun printWinningStatisticsStartLine() {
        println()
        println("Winning Statistics")
        println("---")
    }

    fun printWinningStatistics() {
        println("3 Matches (5,000 KRW) – ${MATCH.THREE} tickets")
        println("4 Matches (50,000 KRW) – ${MATCH.FOUR} tickets")
        println("5 Matches (1,500,000 KRW) – ${MATCH.FIVE} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${MATCH.FIVE_AND_BONUS} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${MATCH.SIX} tickets")
    }

    fun printReturnRate(returnRate: Number) {
        println("Total return rate is $returnRate%.")
    }
}
