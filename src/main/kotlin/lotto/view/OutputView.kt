package lotto.view

import lotto.*
import lotto.constants.Prizes
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
            println("3 Matches (${Prizes.FIFTH.prizeMoney}) – ${lottoResult.winningStatics["three"]} tickets")
            println("4 Matches (${Prizes.FOURTH.prizeMoney}) – ${lottoResult.winningStatics["four"]} tickets")
            println("5 Matches (${Prizes.THIRD.prizeMoney}) – ${lottoResult.winningStatics["five"]} tickets")
            println("5 Matches + Bonus Ball (${Prizes.SECOND.prizeMoney}) – ${lottoResult.winningStatics["bonus"]} tickets")
            println("6 Matches (${Prizes.FIRST.prizeMoney}) ${lottoResult.winningStatics["six"]} tickets")
        }

        fun displayReturnRate(lottoResult: LottoResult) {
            val roundedReturnRate = String.format(Locale.US, "%.1f", lottoResult.returnRate)
            println("Total return rate is $roundedReturnRate%.")
        }
    }
}