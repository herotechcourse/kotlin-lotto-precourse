package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.Rank

/**
 * Handles all user output for the Lotto application.
 *
 * This class is responsible for displaying:
 * - The number of tickets purchased.
 * - The list of generated Lotto tickets as per task requirements.
 *
 * OutputView does not handle any internal game logic or input operations—
 * it only formats and prints data provided by other components.
 *
 * Usage:
 * ```
 * val outputView = OutputView()
 * outputView.printTickets(lottoTickets)
 * ```
 */
class OutputView {
    fun printTickets(tickets: LottoTickets) {
        println("You have purchased ${tickets.size()} tickets.")

        tickets.getAll().forEach { ticket ->
            println(ticket.toString())
        }
    }

    fun printStatistics(result: Map<Rank, Int>) {
        println("\nWinning Statistics")
        println("---")

        Rank.entries
            .sortedByDescending { it.prize }
            .forEach { rank ->
                val count = result[rank] ?: 0
                val matchText = when (rank) {
                    Rank.SECOND -> "5 Matches + Bonus Ball"
                    else -> "${rank.matchCount} Matches"
                }
                println("$matchText (${rank.prize.toString().replace(Regex("(\\d)(?=(\\d{3})+(?!\\d))"), "$1,")} KRW) – $count tickets")
            }
    }

    fun printProfitRate(result: Map<Rank, Int>, totalSpent: Int) {
        val totalPrize = result.entries.sumOf { (rank, count) -> rank.prize * count }
        val rate = totalPrize.toDouble() / totalSpent * 100
        println("Total return rate is ${"%.1f".format(rate)}%.")
    }
}