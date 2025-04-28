package lotto

import kotlin.collections.groupingBy

object OutputView {

    fun printTicketCount(count: Int) {
        println("You have purchased $count tickets")
    }

    fun printTickets(tickets: List<Lotto>) {
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printResult(ranks: List<Rank>, amountSpent: Int) {
        println("\nWinning Statistics")
        println("*****************************************************")

        val rankCount = ranks.groupingBy { it }.eachCount()

        Rank.entries
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val bonusText = if (rank.requiresBonus) ", bonus matched" else ""
                println("${rank.matchCount} matches$bonusText (${rank.prize} won) - ${rankCount[rank] ?: 0} times")
            }

        val totalPrize = ranks.sumOf { it.prize }
        val profitRate = totalPrize.toDouble() / amountSpent * 100

        println("Total return rate: ${"%.1f".format(profitRate)}%")
    }
}
