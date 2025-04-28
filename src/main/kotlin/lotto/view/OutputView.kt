package lotto.view

import lotto.Rank
import lotto.Result
import lotto.Ticket

object OutputView {

    // Prints how many tickets were purchased and lists each ticket's numbers
    fun printTickets(tickets: List<Ticket>) {
        println("${tickets.size} tickets have been purchased.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    // Prints the winning results statistics
    fun printResult(result: Result, purchaseAmount: Int) {
        println("\nWinning Statistics")
        println("---")
        Rank.values()
            .filter { it != Rank.NONE }
            .sortedBy { it.matchCount }
            .forEach { rank ->
                println("${rank.matchCount} matches${if (rank.matchBonus) " + Bonus" else ""} (${rank.prizeMoney} KRW) - ${result.getResultCount(rank)} tickets")
            }
        println("Total return rate is ${"%.1f".format(result.getTotalProfitRate(purchaseAmount))}%.")
    }
}