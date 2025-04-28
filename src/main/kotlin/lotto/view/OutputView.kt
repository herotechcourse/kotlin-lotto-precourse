package lotto.view

import lotto.model.Lotto
import lotto.model.Rank
import lotto.util.ProfitCalculator
import lotto.util.toFormatted
import lotto.util.toPercentageString

object OutputView {

    fun printTickets(lottoTickets: List<Lotto>) {
        println("You have purchased ${lottoTickets.size} tickets.")
        lottoTickets.forEach {
            println(it.getNumbers())
        }
    }

    fun printResult(result: Map<Rank, Int>, ticketCount: Int) {
        println("\nWinning Statistics")
        println("---")
        Rank.entries
            .filter { it != Rank.NONE }
            .forEach { rank ->
                println("${rank.matchCount} ${rank.description} (${rank.prize.toFormatted()} KRW) – ${result[rank]} tickets")
            }
        val totalProfitRate = ProfitCalculator.calculateProfitRate(result, ticketCount)
        println("Total return rate is ${totalProfitRate.toPercentageString()}.")
    }
}