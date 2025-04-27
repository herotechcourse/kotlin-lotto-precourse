package lotto.utils

import lotto.Lotto
import lotto.MatchCategory

object OutputView {

    fun printPurchaseSummary(numberOfTickets: Int) {
        println()
        println("You have purchased $numberOfTickets tickets.")
    }

    fun printTicketsLn(tickets: List<Lotto>) {
        for (ticket in tickets) {
            println(ticket.getNumbers())
        }
        println()
    }

    fun printWinningStatistics(results: Map<MatchCategory, Int>, returnRate: Double) {
        println("Winning Statistics")
        println("---")
        printThreeMatchesStatistics(results)
        printFourMatchesStatistics(results)
        printFiveMatchesStatistics(results)
        printFiveMatchesWithBonusStatistics(results)
        printSixMatchesStatistics(results)
        printReturnRate(returnRate)
    }

    private fun printThreeMatchesStatistics(results: Map<MatchCategory, Int>) {
        val count = results.getValue(MatchCategory.THREE_MATCHES)
        printCategoryStatistics("3 Matches", "5,000", count)
    }

    private fun printFourMatchesStatistics(results: Map<MatchCategory, Int>) {
        val count = results.getValue(MatchCategory.FOUR_MATCHES)
        printCategoryStatistics("4 Matches", "50,000", count)
    }

    private fun printFiveMatchesStatistics(results: Map<MatchCategory, Int>) {
        val count = results.getValue(MatchCategory.FIVE_MATCHES)
        printCategoryStatistics("5 Matches", "1,500,000", count)
    }

    private fun printFiveMatchesWithBonusStatistics(results: Map<MatchCategory, Int>) {
        val count = results.getValue(MatchCategory.FIVE_MATCHES_AND_BONUS)
        printCategoryStatistics("5 Matches + Bonus Ball", "30,000,000", count)
    }

    private fun printSixMatchesStatistics(results: Map<MatchCategory, Int>) {
        val count = results.getValue(MatchCategory.SIX_MATCHES)
        printCategoryStatistics("6 Matches", "2,000,000,000", count)
    }

    private fun printCategoryStatistics(categoryName: String, prize: String, count: Int) {
        println("$categoryName ($prize KRW) – $count tickets")
    }

    private fun printReturnRate(returnRate: Double) {
        val roundedRate = "%.1f".format(returnRate)
        println("Total return rate is $roundedRate%.")
    }
}
