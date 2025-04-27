package lotto

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class OutputView {
    // Formats numbers with commas
    private val prizeFormat = DecimalFormat("#,###", DecimalFormatSymbols(Locale.US))

    // Displays purchased tickets
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers().sorted())
        }
    }

    // Displays statistics and return rate
    fun printStatistics(results: Map<LottoRank, Int>, totalReturnRate: Double) {
        println("\nWinning Statistics")
        println("---")
        val ranks = listOf(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
        ranks.forEach { rank ->
            val count = results[rank] ?: 0
            when (rank) {
                LottoRank.SECOND -> println("5 Matches + Bonus Ball (${prizeFormat.format(rank.prize)} KRW) – $count tickets")
                else -> println("${rank.matches} Matches (${prizeFormat.format(rank.prize)} KRW) – $count tickets")
            }
        }
        println("Total return rate is ${String.format(Locale.US, "%.1f", totalReturnRate)}%.")
    }
} 