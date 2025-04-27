package lotto.view

import lotto.Lotto
import lotto.WinningResult
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class OutputView {
    fun printLottoTickets(tickets: List<Lotto>) {
        println("\nYou have purchased 8 tickets.")
        for (ticket in tickets) {
            val ticketNumbers = ticket.getNumbers().joinToString(", ")
            println("[$ticketNumbers]")
        }
    }

    fun printWinningStatistics(result: WinningResult) {
        println("\nWinning Statistics\n---")
        for (rank in result.getRanksWithCount()) {
            print("${rank.key.matchCount} Matches")
            if (rank.key.isSecond()) print(" + Bonus Ball")
            println(" (${formatPrize(rank.key.prize)} KRW) – ${rank.value} tickets")
        }
        printProfit(result.profit())
    }

    private fun formatPrize(prize: Int): String {
        val formatter = NumberFormat.getNumberInstance(Locale.US)
        return formatter.format(prize)
    }

    private fun printProfit(profit: Double) {
        println("Total return rate is ${formatProfit(profit)}%.")
    }

    private fun formatProfit(profit: Double): String {
        val formatter = DecimalFormat("#,##0.0")
        return formatter.format(profit)
    }
}
