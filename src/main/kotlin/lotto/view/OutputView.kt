package lotto.view

import lotto.model.Lotto
import lotto.model.Rank
import lotto.util.ProfitCalculator
import lotto.util.toFormatted

object OutputView {

    fun printTickets(lottoTickets: List<Lotto>) {
        println("You have purchased ${lottoTickets.size} tickets.")
        lottoTickets.forEach {
            println(it.getNumbers())
        }
    }

    fun printResult(result: Map<Rank, Int>) {
        println("\nWinning Statistics")
        println("---")
        Rank.values()
            .filter { it != Rank.NONE }
            .forEach { rank ->
                println("${rank.description} (${rank.prize.toFormatted()} KRW) – ${result[rank] ?: 0} tickets")
            }
        val totalProfitRate = ProfitCalculator.calculateProfitRate(result)
        println("Total return rate is %.1f%%.".format(totalProfitRate))
    }
}