package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoStatistics
import lotto.domain.LottoTicket
import java.text.NumberFormat
import java.util.Locale

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
        listOf(
            LottoResult.FIFTH,
            LottoResult.FOURTH,
            LottoResult.THIRD,
            LottoResult.SECOND,
            LottoResult.FIRST
        ).forEach { rank ->
            val prizeFormatted = NumberFormat
                .getNumberInstance(Locale.US)
                .format(rank.prize)
            val line = if (rank == LottoResult.SECOND) {
                "${rank.matchCount} Matches + Bonus Ball ($prizeFormatted KRW) – ${statistics.count(rank)} tickets"
            } else {
                "${rank.matchCount} Matches ($prizeFormatted KRW) – ${statistics.count(rank)} tickets"
            }
            println(line)
        }
        println("Total return rate is ${"%.1f".format(Locale.US, statistics.returnRate)}%.")
    }
}
