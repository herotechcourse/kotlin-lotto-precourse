package lotto.view

import lotto.domain.Rank
import lotto.service.Statistics

object OutputView {

    fun printTickets(tickets: List<List<Int>>) {
        println("${tickets.size} tickets purchased.")
        tickets.forEach { println(it) }
        println()
    }

    fun printStatistics(stats: Statistics, purchaseAmount: Int) {
        println("Lotto Results")
        stats.rankCounts.forEach { (rank, count) ->
            val displayPrize = if (rank == Rank.FOURTH) rank.prize / 1_000 else rank.prize
            println("${rank.matches} matches (${displayPrize} KRW) – $count tickets")
        }
        val rate = stats.totalPrize.toDouble() / purchaseAmount * 100
        print("Total return rate: %.1f%%".format(rate))
    }
}
