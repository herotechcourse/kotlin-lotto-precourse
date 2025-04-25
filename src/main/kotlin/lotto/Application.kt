package lotto

import lotto.controller.LottoController
import lotto.domain.LottoMachine
import lotto.util.InputValidator
import lotto.util.LottoNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val inputValidator = InputValidator()
    val numberGenerator = LottoNumberGenerator()

    val lottoMachine = LottoMachine(numberGenerator)
    val controller = LottoController(inputView, outputView, lottoMachine, inputValidator)

    controller.run()
}
