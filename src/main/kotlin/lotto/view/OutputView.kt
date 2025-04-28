package lotto.view

import lotto.domain.Rank
import lotto.service.Statistics

object OutputView {
    fun printTickets(ticketNumbers: List<List<Int>>) {
        println("You have purchased ${ticketNumbers.size} tickets.")
        ticketNumbers.forEach { println(it) }
    }

    fun printStatistics(stats: Statistics, purchaseAmount: Int) {
        println("Winning Statistics")
        println("---")

        listOf(
            Rank.FIFTH,
            Rank.FOURTH,
            Rank.THIRD,
            Rank.SECOND,
            Rank.FIRST
        ).forEach { rank ->
            val count = stats.rankCounts[rank] ?: 0
            val formattedPrize = "%,d".format(rank.prize)
            val matchText = when (rank) {
                Rank.SECOND -> "5 Matches + Bonus Ball"
                else -> "${rank.matches} Matches"
            }
            println("$matchText (${formattedPrize} KRW) – $count tickets")
        }

        val rate = stats.totalPrize.toDouble() / purchaseAmount * 100
        println("Total return rate is %.1f%%.".format(rate))
    }

}

