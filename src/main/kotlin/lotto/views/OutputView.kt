package lotto.views

import lotto.Lotto

class OutputView {
    fun printPurchasedTickets(tickets: List<Lotto>, ticketCount: Int){
        println("You have purchased $ticketCount tickets.")
        tickets.forEach { ticket ->
            println(ticket.getTicketNumbers())
        }
    }
}