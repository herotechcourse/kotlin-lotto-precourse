package lotto.view

import lotto.Lotto
import lotto.view.messages.PromptMessages
import lotto.domain.LottoRank

class OutputView() {

    fun printTicketCount(ticketCount: Int) {
        println(PromptMessages.TICKET_COUNT.with(ticketCount))
    }

    fun printLottoNumbers(tickets: List<Lotto>) {
        tickets.forEach { lotto ->
            println(lotto.numberList())
        }
    }

    fun printWinningStatistics(ranks: List<Int>) {
        println(PromptMessages.WINNING_STATISTICS.message)
        println("---")
        LottoRank.entries
            .filter { it != LottoRank.NONE }
            .reversed()
            .forEach { println(it.getResultMessage(ranks[it.ordinal])) }
    }

    fun printReturnRate(returnRate: Double) {
        println(PromptMessages.TOTAL_RETURN_RATE.with("%.1f".format(returnRate)))
    }

}