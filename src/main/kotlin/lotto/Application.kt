package lotto

import lotto.controller.InputHandler
import lotto.domain.LottoMachine
import lotto.view.OutputView

fun main() {
    val  lottoMachine = LottoMachine(InputHandler.requestPurchaseAmount())
    OutputView.printTickets(lottoMachine.tickets)
}
