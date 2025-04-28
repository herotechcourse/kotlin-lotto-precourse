package lotto

import java.text.NumberFormat
import java.util.Locale

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printResult(result: LottoResult, amountSpent: Int) {
        println("\nWinning Statistics")
        println("---")
        val rankCounts = result.getRankCounts()
        listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST).forEach { rank ->
            println("${rank.matchCount} Matches${if (rank.bonusRequired) " + Bonus Ball" else ""} (${formatMoney(rank.prize)} KRW) – ${rankCounts[rank]} tickets")
        }
        val rate = result.totalWinnings().toDouble() / amountSpent * 100
        println("Total return rate is ${String.format(Locale.US, "%.1f", rate)}%.")
    }

    private fun formatMoney(amount: Int): String {
        return NumberFormat.getNumberInstance(Locale.US).format(amount)
    }
}

