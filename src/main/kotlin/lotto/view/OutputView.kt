package lotto.view

import lotto.controller.response.PurchasedTicketsDto
import lotto.controller.response.statistics.StatisticsDto

class OutputView {
    fun printPurchasedLotto(purchasedLotto: PurchasedTicketsDto) {
        println()
        println("You have purchased ${purchasedLotto.ticketCount} tickets.")
        purchasedLotto.tickets.forEach { ticket -> println(ticket.numbers) }
    }

    fun printStatistics(statisticsDto: StatisticsDto) {
        println()
        println("Winning Statistics")
        println("---")

        statisticsDto.resultDtos.forEach { resultDto ->
            println(PrintFormatter.formatResultMessage(resultDto))
        }
        println(PrintFormatter.formatProfitRateMessage(statisticsDto))
    }
}