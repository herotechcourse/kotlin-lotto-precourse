package lotto.view

import lotto.Lotto
import lotto.domain.LottoResult
import lotto.domain.Prize

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun printStatistics(result: LottoResult, amount: Int) {
        println("\nWinning Statistics")
        println("---")

        Prize.entries.forEach { prize ->
            println("${prize.description} - ${result.getPrizeCount(prize)} tickets")
        }

        val totalWinnings = result.getTotalWinnings()
        val profitRate = calculateProfitRate(totalWinnings, amount)

        println("Total return rate is ${profitRate}%.")
    }

    private fun calculateProfitRate(totalWinnings: Int, amount: Int): String {
        return "%.1f".format((totalWinnings.toDouble() / amount) * 100)
    }
}