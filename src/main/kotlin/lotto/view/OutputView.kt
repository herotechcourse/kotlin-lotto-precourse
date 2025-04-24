package lotto.view

import lotto.Lotto
import lotto.TICKET_COST
import lotto.UserInput
import lotto.ticket.TicketPurchase

class OutputView {
    companion object {
        fun displayPurchaseMessage(ticketPurchase: TicketPurchase) {
            val amountOfTicketsBought: Int = ticketPurchase.amountOfTicketsBought
            println("You have purchased $amountOfTicketsBought tickets.")
        }

        fun displayBoughtTickets(ticketPurchase: TicketPurchase) {
            val tickets = ticketPurchase.tickets
            for (ticket in tickets) {
                println(ticket.numbers)
            }
            println()
        }

        fun displayWinningStatistics(lotto: Lotto) {
            println("Winning statistics")
            println("---")
        }

        fun displayReturnRate(lotto: Lotto) {
            println("Total return rate is X%.")
        }
    }
}