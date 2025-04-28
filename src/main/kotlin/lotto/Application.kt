package lotto

import lotto.controller.LottoController
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val controller = LottoController(
        InputView(),
        OutputView(),
    )
    controller.start()
}
