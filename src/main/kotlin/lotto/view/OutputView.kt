package lotto.view

import lotto.model.Lotto
import lotto.model.Prize
import java.util.Locale

object OutputView {

    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.toString()) }
    }

    fun printStatistics(rankCount: Map<Prize, Int>, returnRate: Double) {
        println("Winning Statistics\n---")
        rankCount.forEach { (rank, count) ->
            println("${rank.output} – $count tickets")
        }

        println("Total return rate is ${"%.1f".format(Locale.ENGLISH, returnRate)}%.")
    }

}