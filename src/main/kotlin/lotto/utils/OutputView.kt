package lotto.utils

import lotto.Lotto
import lotto.core.Prize

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket.display())
        }
    }

    fun printResult(
        result: Map<Prize, Int>,
        returnRate: Double
    ) {
        println()
        val prizes = listOf(Prize.FIFTH, Prize.FOURTH, Prize.THIRD,Prize.SECOND, Prize.FIRST)
        prizes.forEach { prize ->
            val count = result.getOrDefault(prize, defaultValue = 0)
            println("${prize.display} – $count tickets")
        }

        println("Total return rate is %.1f%%.".format(returnRate))
    }

}