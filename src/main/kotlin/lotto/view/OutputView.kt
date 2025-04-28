package lotto.view

import lotto.Lotto
import lotto.model.LotteryResult
import lotto.model.PrizeTier
import java.text.DecimalFormat

class OutputView {

    fun printTicketCount(count: Int) {
        println("You have purchased $count tickets.")
    }

    fun printTickets(tickets: List<Lotto>) {
        tickets.forEach { println(it) }
    }

    fun printResult(result: LotteryResult) {
        println("\nWinning Statistics")
        println("---")

        PrizeTier.entries.forEach { prizeTier ->
            val count = result.getPrizeTierCount(prizeTier)
            val formattedMoney = formatMoney(prizeTier.prizeMoney)
            println("${prizeTier.description} (${formattedMoney} KRW) – $count tickets")
        }
    }

    fun printReturnRate(result: LotteryResult) {
        val returnRate = String.format("%.1f", result.getReturnRate())

        println("Total return rate is $returnRate%")
    }

    private fun formatMoney(amount: Long): String {
        val formatter = DecimalFormat("#,###,###")

        return formatter.format(amount)
    }
}