package lotto

import lotto.controller.LottoController
import lotto.presentation.InputViewImpl
import lotto.presentation.OutputViewImpl
import lotto.utils.InputValidatorImpl

fun main() {
    val lottoController = LottoController(
        inputView = InputViewImpl(),
        inputValidator = InputValidatorImpl(),
        outputView = OutputViewImpl(),
    )
    lottoController.run()
}
