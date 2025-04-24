package lotto

import lotto.Game.Prize
import java.util.DoubleSummaryStatistics

class OutputView(tickets: List<Lotto>) {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets")
        tickets.map {
            println(it.getNumbers())
        }
        println()
    }

}