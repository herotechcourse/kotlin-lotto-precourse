package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.controller.LottoController

fun main() {

    val inputView = InputView()
    val outputView = OutputView()
    val lottoController = LottoController(inputView, outputView)

    lottoController.run()
}
