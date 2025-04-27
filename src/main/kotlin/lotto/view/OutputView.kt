package lotto.view

import lotto.Lotto

class OutputView {

    fun displayError(message: String?) {
        println(message)
    }

    fun displayPurchaseCount(count: Int) {
        println("\nYou have purchased $count tickets.")
    }

    fun displayLottoTickets(tickets: List<Lotto>) {
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

}