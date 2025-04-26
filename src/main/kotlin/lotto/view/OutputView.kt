package lotto.view

import lotto.LottoMachine
import lotto.messages.PromptMessages

class OutputView {

    fun printTicketCount(lottoMachine: LottoMachine) {
        val ticketCount = lottoMachine.tickets.size
        println(PromptMessages.TICKET_COUNT.with(ticketCount))
    }

    fun printLottoNumbers(lottoMachine: LottoMachine) {
        lottoMachine.tickets.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }
}