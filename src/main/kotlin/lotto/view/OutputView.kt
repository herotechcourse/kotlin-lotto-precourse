package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoStatistics
import lotto.domain.LottoTicket

object OutputView {

    fun printTickets(tickets: List<LottoTicket>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.numbers)
        }
        println()
    }

    fun printStatistics(statistics: LottoStatistics) {
        println("Lotto result statistics:")
        LottoResult.entries.forEach { rank ->
            val count = statistics.count(rank)
            println("${rank.matchCount} Matches (${rank.prize} KRW) – $count tickets")
        }
        println("Total return rate is ${"%.1f".format(statistics.profitRate)}%.")
    }
}
