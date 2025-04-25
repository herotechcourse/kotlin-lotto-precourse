package lotto.view

import lotto.LottoResult
import lotto.TicketPurchase

class OutputView {
    companion object {
        fun displayPurchaseMessage(ticketPurchase: TicketPurchase) {
            val amountOfTicketsBought: Int = ticketPurchase.amountOfTicketsBought
            println("You have purchased $amountOfTicketsBought tickets.")
        }

        fun displayBoughtTickets(ticketPurchase: TicketPurchase) {
            val tickets = ticketPurchase.tickets
            for (ticket in tickets) {
                println(ticket.getNumbers())
            }
            println()
        }

        fun displayWinningStatistics(lottoResult: LottoResult) {
            println("Winning statistics")
            println("---")
        }

        fun displayReturnRate(lottoResult: LottoResult) {
            println("Total return rate is X%.")
        }
    }
}