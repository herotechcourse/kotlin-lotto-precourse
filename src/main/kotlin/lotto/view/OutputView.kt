package lotto.view

import lotto.*
import lotto.constants.Prizes
import java.text.NumberFormat
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
            val formatter = NumberFormat.getNumberInstance(Locale.US)

            println("Winning statistics")
            println("---")
            println("3 Matches (${formatter.format(Prizes.FIFTH.prizeMoney)} KRW) – ${lottoResult.winningStatics["three"]} tickets")
            println("4 Matches (${formatter.format(Prizes.FOURTH.prizeMoney)} KRW) – ${lottoResult.winningStatics["four"]} tickets")
            println("5 Matches (${formatter.format(Prizes.THIRD.prizeMoney)} KRW) – ${lottoResult.winningStatics["five"]} tickets")
            println("5 Matches + Bonus Ball (${formatter.format(Prizes.SECOND.prizeMoney)} KRW) – ${lottoResult.winningStatics["bonus"]} tickets")
            println("6 Matches (${formatter.format(Prizes.FIRST.prizeMoney)} KRW) – ${lottoResult.winningStatics["six"]} tickets")
        }

        fun displayReturnRate(lottoResult: LottoResult) {
            val roundedReturnRate = String.format(Locale.US, "%.1f", lottoResult.returnRate)
            println("Total return rate is $roundedReturnRate%.")
        }
    }
}