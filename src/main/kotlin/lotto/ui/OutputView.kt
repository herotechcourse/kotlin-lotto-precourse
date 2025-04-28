package lotto.ui

import lotto.Lotto
import lotto.core.Rank

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printStatistics(stats: Map<Rank, Int>) {
        println("\nWinning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${stats[Rank.THREE]} tickets")
        println("4 Matches (50,000 KRW) – ${stats[Rank.FOUR]} tickets")
        println("5 Matches (1,500,000 KRW) – ${stats[Rank.FIVE]} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${stats[Rank.FIVE_PLUS]} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${stats[Rank.SIX]} tickets")
    }

    fun printProfitRate(rate: Double) {
        println("Total return rate is $rate%.")
    }
}
