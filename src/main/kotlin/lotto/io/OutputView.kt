package lotto.io

import lotto.Lotto
import lotto.domain.LottoResult
import lotto.domain.PrizeCategory


class OutputView(private val io: IOInterface) {

    fun printPurchasedTickets(tickets: List<Lotto>) {
        io.print("You have purchased ${tickets.size} tickets.")

        tickets.forEach { ticket ->
            io.print(ticket.getNumbers().toString())
        }
    }

    fun printResult(result: LottoResult, profitRate: Double) {
        io.print("\nWinning Statistics\n---")

        PrizeCategory.entries
            .filter { it != PrizeCategory.NONE } // Exclude NONE
            .forEach { prize ->
                val count = result.statistics.getOrDefault(prize, 0)
                val formattedPrizeAmount = "%,d".format(prize.prizeAmount)
                io.print("${prize.description} (${formattedPrizeAmount} KRW) – $count tickets")
            }

        io.print("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}
