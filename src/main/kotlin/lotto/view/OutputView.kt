package lotto.view

import lotto.model.Prize
import lotto.model.Rank

object OutputView {
    fun printPurchasedTickets(totalSize: Int, ticketNumbers: List<List<Int>>) {
        println("You have purchased $totalSize tickets.")
        ticketNumbers.forEach { println(it) }
    }

    fun printWinningStatistics(prizes: List<Prize>, profitRate: Double) {
        println("Winning Statistics")
        println("---")
        Rank.entries.reversed().forEach { rank ->
            if (rank == Rank.NONE) return@forEach
            val bonusText = if (rank == Rank.SECOND) " + Bonus Ball" else ""
            val formattedReward = String.format("%,d", rank.reward)
            val count = prizes.filter { it.getRank() == rank }.size
            println("${rank.matchCount} Matches${bonusText} (${formattedReward} KRW) – $count tickets")
        }
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}