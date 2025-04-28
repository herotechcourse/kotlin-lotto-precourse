package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoTicket
import lotto.view.InputView

class LottoController {
    init {
        var values = InputView.inputPurchase().toLong()
        val ticketCount = (values / 1000).toInt()

        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.issueLotto(ticketCount)
        tickets.forEach {
            ticket -> println(ticket.getNumbers())
        }
    }
}
