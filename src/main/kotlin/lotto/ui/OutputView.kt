package lotto.ui

import lotto.Lotto
import lotto.domain.PrizeRank

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun printResults(results: Map<PrizeRank, Int>) {
        println("\nWinning Statistics")
        println("---")
        PrizeRank.entries
            .filter { it != PrizeRank.NONE }
            .reversed()
            .forEach { rank ->
            val count = results[rank] ?: 0
            val prizeAmount = rank.prizeAmount.toString().replace(Regex("(\\d)(?=(\\d{3})+$)"), "$1,")
            val bonusText = if (rank.hasBonus) " + Bonus Ball" else ""
            println("${rank.matchCount} Matches${bonusText} (${prizeAmount} KRW) – $count tickets")
        }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}