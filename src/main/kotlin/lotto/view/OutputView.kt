package lotto.view

import lotto.Lotto
import lotto.model.LottoResult
import lotto.model.PrizeRank
import lotto.util.PrizeRankSorter

// Handles all output display for the lottery program
object OutputView {

    // Prints the number of lottery tickets purchased
    fun printTicketCount(ticketCount: Int) {
        println()
        println("You have purchased $ticketCount tickets.")
    }

    // Prints all generated lottery tickets
    fun printLottoTickets(tickets: List<Lotto>) {
        for (ticket in tickets) {
            println(ticket)
        }
    }

    // Prints the overall winning statistics and profit rate
    fun printWinningStatistics(result: LottoResult, totalSpent: Int) {
        println()
        println("Winning Statistics")
        println("---")

        val results = result.getResults()

        // Print the number of tickets per winning rank
        for (rank in PrizeRankSorter.sort()) {
            val count = results[rank] ?: 0
            printRank(rank, count)
        }

        // Print the overall profit rate
        printProfitRate(result.calculateProfitRate(totalSpent))
    }

    // Prints the result for a specific winning rank
    private fun printRank(rank: PrizeRank, count: Int) {
        val formattedPrizeMoney = String.format("%,d", rank.prizeMoney)

        when (rank) {
            PrizeRank.SECOND -> {
                println("${rank.matchCount} Matches + Bonus Ball (${formattedPrizeMoney} KRW) – $count tickets")
            }
            else -> {
                println("${rank.matchCount} Matches (${formattedPrizeMoney} KRW) – $count tickets")
            }
        }
    }

    // Prints the final profit rate percentage
    private fun printProfitRate(profitRate: Double) {
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }
}
