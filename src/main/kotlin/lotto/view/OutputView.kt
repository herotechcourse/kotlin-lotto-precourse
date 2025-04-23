package lotto.view

import lotto.Lotto

class OutputView {

    fun displayPurchasedTicketsInfo(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")

        tickets.forEach { ticket ->
            println(ticket.toString())
        }
    }
}