package lotto

import lotto.controller.LottoController
import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoController(
        InputView(),
        OutputView(),
        LottoGame()
    ).run()
}
