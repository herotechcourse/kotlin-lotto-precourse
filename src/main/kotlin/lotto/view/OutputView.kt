package lotto.view

import lotto.*
import java.util.*

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
            println("3 Matches ($FIFTH_PRIZE) – ${lottoResult.winningStatics["three"]} tickets")
            println("4 Matches ($FOURTH_PRIZE) – ${lottoResult.winningStatics["four"]} tickets")
            println("5 Matches ($THIRD_PRIZE) – ${lottoResult.winningStatics["five"]} tickets")
            println("5 Matches + Bonus Ball ($SECOND_PRIZE) – ${lottoResult.winningStatics["bonus"]} tickets")
            println("6 Matches ($FIRST_PRIZE) ${lottoResult.winningStatics["six"]} tickets")
        }

        fun displayReturnRate(lottoResult: LottoResult) {
            val roundedReturnRate = String.format(Locale.US, "%.1f", lottoResult.returnRate)
            println("Total return rate is $roundedReturnRate%.")
        }
    }
}