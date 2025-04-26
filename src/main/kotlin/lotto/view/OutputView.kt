package lotto.view

import lotto.Lotto
import lotto.Rank

object OutputView {

    fun printTicketCount(count: Int) {
        println("You have purchased $count tickets.")
    }

    fun printTickets(tickets: List<Lotto>) {
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printStatistics(rankCounts: Map<Rank, Int>) {
        println()
        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${rankCounts[Rank.FIFTH] ?: 0} tickets")
        println("4 Matches (50,000 KRW) – ${rankCounts[Rank.FOURTH] ?: 0} tickets")
        println("5 Matches (1,500,000 KRW) – ${rankCounts[Rank.THIRD] ?: 0} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${rankCounts[Rank.SECOND] ?: 0} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${rankCounts[Rank.FIRST] ?: 0} tickets")
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}
