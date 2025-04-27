package lotto

import java.util.Locale

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printResult(result: Map<Rank, Int>) {
        println("\nWinning Statistics\n---")
        var totalPrize = 0
        for (rank in Rank.values()) {
            if (rank != Rank.NONE) {
                val count = result.getValue(rank)
                println("${rank.message} – $count tickets")
                totalPrize += count * rank.prize
            }
        }
        val totalSpent = result.values.sum() * 1000
        val rate = if (totalSpent == 0) 0.0 else totalPrize.toDouble() / totalSpent * 100
        println("Total return rate is ${String.format(Locale.US, "%.1f", rate)}%.")
    }
}