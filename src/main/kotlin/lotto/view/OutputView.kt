package lotto.view

import lotto.Lotto
import lotto.domain.Rank

object OutputView {

    // This function prints the list of purchased lotto tickets
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    // This function prints the winning statistics, including the prize for each rank and the total return rate
    fun printStatistics(results: Map<Rank, Int>, purchaseAmount: Int) {
        println("\nWinning Statistics\n---")
        Rank.values().filter { it != Rank.NONE }.forEach {
            val count = results.getOrDefault(it, 0)
            val bonus = if (it.hasBonus) "+ Bonus Ball " else ""
            println("${it.matchCount} Matches $bonus(${String.format("%,d", it.prize)} KRW) – $count tickets")
        }
        val totalPrize = results.entries.sumOf { it.key.prize * it.value }
        val profitRate = totalPrize.toDouble() / purchaseAmount * 100
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }
}
