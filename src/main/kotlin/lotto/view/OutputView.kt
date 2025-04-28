package lotto.view

import lotto.Lotto
import lotto.domain.Rank

object OutputView {
    fun printPurchaseCount(count: Int) {
        println()
        println("You have purchased $count tickets.")
    }

    fun printLottoTickets(tickets: List<Lotto>) {
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
        println()
    }

    fun printResultStatistics(counts: Map<Rank, Int>) {
        println()
        println("Winning Statistics")
        println("---")
        listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST).forEach { rank ->
            val bonusText = if (rank == Rank.SECOND) " + Bonus Ball" else ""
            println("${rank.matchCount} Matches${bonusText} (${formatCurrency(rank.prize)} KRW) – ${counts[rank]} tickets")
        }
    }

    fun printTotalYield(yield: Double) {
        val formattedYield = String.format("%.1f", yield)
        println("Total return rate is ${formattedYield}%.")
    }

    private fun formatCurrency(amount: Long): String {
        return "%,d".format(amount)
    }
}