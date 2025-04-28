package lotto.view

import lotto.Lotto
import lotto.domain.LottoResult
import lotto.domain.Rank

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")

        tickets.forEach { println(it) }
    }

    fun printResult(result: LottoResult, amount: Int) {
        println("\nWinning Statistics\n---")

        for (rank in Rank.entries.filter { it != Rank.NONE }.sortedBy { it.prize }) {
            val formattedPrize = String.format("%,d", rank.prize)
            println("${rank.matchCount} Matches${if (rank == Rank.SECOND) " + Bonus Ball" else ""} ($formattedPrize KRW) – ${result.getResults()[rank] ?: 0} tickets")

        }


        println("Total return rate is ${result.profitRate(amount)}%.")
    }
}
