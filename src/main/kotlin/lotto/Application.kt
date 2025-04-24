package lotto

import lotto.controller.LottoController
import lotto.utils.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val inputValidator = InputValidator()
    val lottoController = LottoController(inputView, outputView, inputValidator)

    lottoController.run()
}
