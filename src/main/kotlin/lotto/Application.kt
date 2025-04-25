package lotto

import lotto.service.TicketMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoController(
        machine = TicketMachine(),
        input   = InputView,
        output  = OutputView
    ).run()
}