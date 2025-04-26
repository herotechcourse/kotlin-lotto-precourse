package lotto.utils

import lotto.Lotto

object OutputView {

    // TODO: implement integration test
    fun printTicketsLn(tickets: List<Lotto>) {
        for (ticket in tickets) {
            println(ticket.getNumbers())
        }
        println()
    }
}