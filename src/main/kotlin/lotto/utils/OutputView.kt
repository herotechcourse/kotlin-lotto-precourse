package lotto.utils

import lotto.Lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket.display())
        }
    }

}