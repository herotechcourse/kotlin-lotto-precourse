package lotto.controller

import lotto.domain.LottoTicket
import lotto.view.InputView

class LottoController {
    init {
        var values = InputView.inputPurchase().toLong()
        println("input : $values")
        val lottoTicket = LottoTicket(values)
        val countPaper = lottoTicket.ticketCount()
    }
}
