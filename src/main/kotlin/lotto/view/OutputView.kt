package lotto.view

import lotto.Lotto
import lotto.services.LottoResult
import lotto.services.Prize

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket.getNumbers())
        }
    }

    fun printStatistics(result: LottoResult) {
        println("\nWinning Statistics\n---")

        for (prize in Prize.entries.reversed()) {
            val count = result.getResult()[prize] ?: 0
            val formattedPrizeMoney = "%,d".format(prize.prizeMoney)

            when (prize) {
                Prize.SECOND -> println("5 Matches + Bonus Ball (${formattedPrizeMoney} KRW) – ${count} tickets")
                else -> println("${prize.matchCount} Matches (${formattedPrizeMoney} KRW) – ${count} tickets")
            }
        }

        println("Total return rate is ${"%.1f".format(result.getProfitRate(result.tickets.size * 1000))}%.")
    }
}