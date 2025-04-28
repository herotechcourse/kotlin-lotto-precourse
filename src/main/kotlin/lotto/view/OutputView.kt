package lotto.view

import lotto.controller.response.PurchasedTicketsDto
import lotto.controller.response.StatisticsDto

class OutputView {
    fun printPurchasedLotto(purchasedLotto: PurchasedTicketsDto) {
        println()
        println(PrintFormatter.formatTicketMessage(purchasedLotto.ticketCount))
        purchasedLotto.tickets.forEach { ticket -> println(ticket.numbers) }
    }

    fun printStatistics(statisticsDto: StatisticsDto) {
        println()
        println(WINNING_STATISTICS_TITLE)
        println(TITLE_TAG)

        statisticsDto.resultDtos.forEach { resultDto ->
            println(PrintFormatter.formatResultMessage(resultDto))
        }
        println(PrintFormatter.formatProfitRateMessage(statisticsDto))
    }

    companion object {
        private const val WINNING_STATISTICS_TITLE = "Winning Statistics"
        private const val TITLE_TAG = "---"
    }
}