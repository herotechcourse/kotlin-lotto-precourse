package lotto.view

import lotto.LottoResult
import lotto.TicketPurchase
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
            displayWinningStatisticsHeader()
            displayWinningStatisticsBody(lottoResult)
        }

        private fun displayWinningStatisticsHeader() {
            println("Winning statistics")
            println("---")
        }

        private fun displayWinningStatisticsBody(lottoResult: LottoResult) {
            val formatter = NumberFormat.getNumberInstance(Locale.US)
            println("3 Matches (${formatter.format(Prizes.FIFTH.prizeMoney)} KRW) – ${lottoResult.winningStatistics["three"]} tickets")
            println("4 Matches (${formatter.format(Prizes.FOURTH.prizeMoney)} KRW) – ${lottoResult.winningStatistics["four"]} tickets")
            println("5 Matches (${formatter.format(Prizes.THIRD.prizeMoney)} KRW) – ${lottoResult.winningStatistics["five"]} tickets")
            println("5 Matches + Bonus Ball (${formatter.format(Prizes.SECOND.prizeMoney)} KRW) – ${lottoResult.winningStatistics["bonus"]} tickets")
            println("6 Matches (${formatter.format(Prizes.FIRST.prizeMoney)} KRW) – ${lottoResult.winningStatistics["six"]} tickets")
        }

        fun displayReturnRate(lottoResult: LottoResult) {
            val roundedReturnRate = String.format(Locale.US, "%.1f", lottoResult.returnRate)
            println("Total return rate is $roundedReturnRate%.")
        }
    }
}