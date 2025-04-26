// OutputView.kt
package lotto.io

import lotto.domain.LottoResult

class OutputView(private val io: IOInterface) {
    fun printPurchasedTickets(tickets: List<LottoTicket>) {
        io.print("You have purchased ${tickets.size} tickets.")
        tickets.forEach {
            io.print(it.numbers.toString())
        }
    }

    fun printResult(result: LottoResult, profitRate: Double) {
        io.print("Winning Statistics\n---")
        result.statistics.forEach { (prize, count) ->
            io.print("${prize.description()} – ${count} tickets")
        }
        io.print("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}
