package lotto.views

import lotto.Lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it) }
    }

}

