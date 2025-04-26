package lotto.view

import lotto.Lotto

class OutputView {
    fun printLottoTickets(tickets: List<Lotto>) {
        println("\nYou have purchased 8 tickets.")
        for (ticket in tickets) {
            val ticketNumbers = ticket.getNumbers().joinToString(", ")
            println("[$ticketNumbers]")
        }
    }
}
