package lotto

import lotto.service.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoController(
        machine = LottoMachine(),
        input   = InputView,
        output  = OutputView
    ).run()
}