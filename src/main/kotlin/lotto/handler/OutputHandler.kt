package lotto.handler

import lotto.Lotto

class OutputHandler {

    fun displayPurchasedTicketsInfo(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")

        tickets.forEach { ticket ->
            println(ticket.toString())
        }
    }
}