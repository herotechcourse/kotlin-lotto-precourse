package lotto.view

import lotto.Lotto

object OutputView {

    fun printTicketCount(ticketCount: Int) {
        println("You have purchased $ticketCount tickets.")
    }

    fun printLottoTickets(tickets: List<Lotto>) {
        for (ticket in tickets) {
            println(ticket)
        }
    }
}
