package lotto.views

import lotto.Lotto
import lotto.Rank

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun printResultStatistics(results: Map<Rank, Int>, profitRate: Double) {
        println("Lotto result statistics:")
        Rank.entries
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val count = results.getOrDefault(rank, 0)
                val label = when(rank) {
                    Rank.SECOND -> "${rank.matchCount} Matches + Bonus Ball"
                    else       -> "${rank.matchCount} Matches"
                }
                println(
                    "$label (${"%,d".format(rank.prize)} KRW) – $count tickets"
                )
            }
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }
}
