package lotto.io

import lotto.domain.Lotto
import lotto.domain.LottoResult

class OutputView(private val io: IOInterface) {

    fun printPurchasedTickets(tickets: List<Lotto>) {
        io.print("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            io.print(ticket.getNumbers().toString())
        }
    }

    fun printResult(result: LottoResult, profitRate: Double) {
        io.print("\nWinning Statistics\n---")
        result.statistics.forEach { (prize, count) ->
            io.print("${prize.description()} – ${count} tickets")
        }
        io.print("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}
