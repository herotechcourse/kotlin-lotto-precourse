package lotto.view

import lotto.Lotto
import lotto.model.LottoResult
import lotto.model.PrizeRank
import lotto.util.PrizeRankSorter

object OutputView {

    fun printTicketCount(ticketCount: Int) {
        println()
        println("You have purchased $ticketCount tickets.")
    }

    fun printLottoTickets(tickets: List<Lotto>) {
        for (ticket in tickets) {
            println(ticket)
        }
    }

    fun printWinningStatistics(result: LottoResult, totalSpent: Int) {
        println()
        println("Winning Statistics")
        println("---")

        val results = result.getResults()

        for (rank in PrizeRankSorter.sort()) {
            val count = results[rank] ?: 0
            printRank(rank, count)
        }

        printProfitRate(result.calculateProfitRate(totalSpent))
    }

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


    private fun printProfitRate(profitRate: Double) {
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }

}
