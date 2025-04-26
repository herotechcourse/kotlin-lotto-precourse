package lotto.view

import lotto.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println()
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
        println()
    }

    fun printResult(result: LottoResult) {
        println("Winning Statistics")
        println("---")
        
        val rankCounts = result.getRankCounts()
        
        // Print in reverse order (from highest to lowest rank)
        listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST).forEach { rank ->
            println("${rank.description} – ${rankCounts[rank]} tickets")
        }
        
        println("Total return rate is ${result.getFormattedProfitRate()}%.")
    }

    fun printError(message: String) {
        println(message)
    }
}
