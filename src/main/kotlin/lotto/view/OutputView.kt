package lotto.view

import lotto.Lotto
import lotto.constants.LottoRank
import lotto.constants.OutputMessage

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println(OutputMessage.TICKETS.format(tickets.size))
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printStatistics(statistics: Map<LottoRank, Int>, profit: Double) {
        println("Winning Statistics")
        println("---")
        LottoRank.orderedRanks().map { rank ->
            val count = statistics.getOrDefault(rank, 0)
            println("${rank.description} – $count tickets")
        }
        println(OutputMessage.PROFIT_RATE.format(profit))
    }
}