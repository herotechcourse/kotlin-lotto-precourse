package lotto.view

import lotto.domain.Rank
import lotto.domain.LottoTicket

object OutputView {

    fun printLottoTickets(tickets: List<LottoTicket>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers().sorted())
        }
    }

    fun printResults(results: Map<Rank, Int>) {
        println("Winning Statistics")
        println("---")
        Rank.values()
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val count = results[rank] ?: 0
                println("${rank.prizeName} (${formatAmount(rank.prizeAmount)} KRW) – $count tickets")
            }
    }
    private fun formatAmount(amount: Long): String {
        return "%,d".format(amount)
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is %.1f%%.".format(profitRate))
    }
}

