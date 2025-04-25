package lotto

import lotto.controller.Controller
import lotto.view.InputView
import lotto.view.LottoViewFormatter
import lotto.view.OutputView

fun main() {
    val controller = Controller(
        LottoStore(RandomLottoMachine),
        InputView,
        OutputView(LottoViewFormatter),
    )
    controller.run()
}

