package lotto.view

import lotto.domain.LottoMachine
import lotto.view.messages.PromptMessages
import lotto.domain.LottoRank

class OutputView(private val lottoMachine: LottoMachine) {

    fun printTicketCount() {
        val ticketCount = lottoMachine.tickets.size
        println(PromptMessages.TICKET_COUNT.with(ticketCount))
    }

    fun printLottoNumbers() {
        lottoMachine.tickets.forEach { lotto ->
            println(lotto.getNumbers().sorted())
        }
    }

    fun printWinningStatistics(guessNumbers: Set<Int>, bonusNumber: Int) {
        println(PromptMessages.WINNING_STATISTICS.message)
        println("---")
        printRank(guessNumbers, bonusNumber)
    }

    private fun printRank(guessNumbers: Set<Int>, bonusNumber: Int) {
        val ranks = lottoMachine.setAllRank(guessNumbers, bonusNumber)
        LottoRank.entries
            .filter { it != LottoRank.NONE }
            .reversed()
            .forEach { println(it.getResultMessage(ranks[it.ordinal])) }
    }

    fun printReturnRate() {
        println(PromptMessages.TOTAL_RETURN_RATE.with(lottoMachine.calculateReturnRate()))
    }

}