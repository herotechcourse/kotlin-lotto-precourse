package lotto.view

import lotto.LottoMachine
import lotto.messages.PromptMessages

class OutputView {

    fun printTicketCount(lottoMachine: LottoMachine) {
        val ticketCount = lottoMachine.countTickets()
        println(PromptMessages.TICKET_COUNT.with(ticketCount))
    }
}