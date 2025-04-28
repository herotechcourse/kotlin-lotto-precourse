package view

import lotto.Calculator
import lotto.Lotto
import lotto.PrizeRankCriteria
import java.util.*

object OutputView {
    fun printIssuedTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.onEach { println(it) }
    }

    fun printStatistic(result: Map<PrizeRankCriteria, Int>, purchaseAmount: Int) {
        println("Winning Statistics")
        println("–––")
        PrizeRankCriteria
            .entries
            .filter { it != PrizeRankCriteria.NONE }
            .sortedDescending()
            .onEach { println("${it.label} – ${result.getOrDefault(it, 0)} tickets") }
        printRate(Calculator.rate(result, purchaseAmount))
    }

    private fun printRate(profitRate: Double) {
        println("Total return rate is %.1f%%".format(Locale.US, profitRate))
    }
}