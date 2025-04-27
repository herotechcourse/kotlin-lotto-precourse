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
        MatchCategory.entries
            .sortedBy { it.ordinal }
            .forEach { category ->
                printCategoryStatistics(category, results)
            }
        printReturnRate(returnRate)
    }

    private fun printCategoryStatistics(category: MatchCategory, results: Map<MatchCategory, Int>) {
        val count = results.getValue(category)
        val formattedPrize = "%,d".format(category.prizeAmount)
        val displayName = category.displayName
        println("$displayName ($formattedPrize KRW) – $count tickets")
    }

    private fun printReturnRate(returnRate: Double) {
        val roundedRate = "%.1f".format(returnRate)
        println("Total return rate is $roundedRate%.")
    }
}
