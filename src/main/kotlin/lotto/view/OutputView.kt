package lotto.view

import lotto.Lotto
import lotto.domain.WinningPrizeRanks

object OutputView {
    fun printLottoTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")

        for (ticket in tickets) {
            println("[${ticket.getNumbers.joinToString(", ")}]")
        }
    }

    fun printWinningStatistics(winningStatistics: Map<WinningPrizeRanks, Int>) {
        println("Winning Statistics")
        println("---")

        println(
                "${WinningPrizeRanks.FIFTH.criteria} Matches (${String.format("%,d", WinningPrizeRanks.FIFTH.prize)} KRW) – ${winningStatistics[WinningPrizeRanks.FIFTH] ?: 0} tickets"
        )
        println(
                "${WinningPrizeRanks.FOURTH.criteria} Matches (${String.format("%,d", WinningPrizeRanks.FOURTH.prize)} KRW) – ${winningStatistics[WinningPrizeRanks.FOURTH] ?: 0} tickets"
        )
        println(
                "${WinningPrizeRanks.THIRD.criteria} Matches (${String.format("%,d", WinningPrizeRanks.THIRD.prize)} KRW) – ${winningStatistics[WinningPrizeRanks.THIRD] ?: 0} tickets"
        )
        println(
                "${WinningPrizeRanks.SECOND.criteria} Matches + Bonus Ball (${String.format("%,d", WinningPrizeRanks.SECOND.prize)} KRW) – ${winningStatistics[WinningPrizeRanks.SECOND] ?: 0} tickets"
        )
        println(
                "${WinningPrizeRanks.FIRST.criteria} Matches (${String.format("%,d", WinningPrizeRanks.FIRST.prize)} KRW) – ${winningStatistics[WinningPrizeRanks.FIRST] ?: 0} tickets"
        )
    }

    fun printTotalEarnings(profitRate: Double) {
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}
