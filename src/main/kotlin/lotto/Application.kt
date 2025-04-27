package lotto

import lotto.controller.LottoController
import lotto.presentation.InputViewImpl
import lotto.presentation.OutputViewImpl

fun main() {
    val lottoController = LottoController(
        inputView = InputViewImpl(),
        inputValidator = InputValidatorImpl(),
        outputView = OutputViewImpl(),
        lottoTicketGenerator = LottoTicketGeneratorImpl(),
    )
    lottoController.run()
}
