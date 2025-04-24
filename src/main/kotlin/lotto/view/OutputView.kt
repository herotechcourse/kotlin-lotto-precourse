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
        println("Lotto result statistics:")
        results.forEach { (rank, count) ->
            println("${rank.prizeName} – $count tickets")
        }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is %.1f%%.".format(profitRate))
    }
}
