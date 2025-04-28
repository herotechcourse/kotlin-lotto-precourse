package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.Rank

object OutputView {
    fun printPurchaseCount(count: Int) {
        println("You have purchased $count tickets.")
    }

    fun printLottoTickets(tickets: List<LottoTicket>) {
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun printResultStatistics(counts: Map<Rank, Int>) {
        println("Lotto result statistics:")
        listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST).forEach { rank ->
            val bonusText = if (rank == Rank.SECOND) " + Bonus Ball" else ""
            println("${rank.matchCount} Matches${bonusText} (${formatCurrency(rank.prize)} KRW) – ${counts[rank]} tickets")
        }
    }

    fun printTotalYield(yield: Double) {
        println("Total return rate is ${yield}%.")
    }

    private fun formatCurrency(amount: Long): String {
        return "%,d".format(amount)
    }
}