package lotto.view

import lotto.Lotto
import lotto.domain.Rank

object OutputView {

    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it) }
    }

    fun printStatistics(resultMap: Map<Rank, Int>, profitRate: Double) {
        println("Winning Statistics")
        println("---")

        val displayOrder = listOf(
            Rank.FIFTH,
            Rank.FOURTH,
            Rank.THIRD,
            Rank.SECOND,
            Rank.FIRST
        )

        for (rank in displayOrder) {
            val count = resultMap[rank] ?: 0
            val bonusText = if (rank == Rank.SECOND) " + Bonus Ball" else ""
            val formattedPrize = "%,d".format(rank.prize)
            println("${rank.matchCount} Matches$bonusText ($formattedPrize KRW) – $count tickets")
        }

        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }
}