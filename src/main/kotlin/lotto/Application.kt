package lotto

import lotto.controller.LottoControllerImpl
import lotto.presentation.InputViewImpl
import lotto.presentation.OutputViewImpl

fun main() {
    val lottoController = LottoControllerImpl(
        inputView = InputViewImpl(),
        inputValidator = InputValidatorImpl(),
        outputView = OutputViewImpl(),
        lottoTicketGenerator = LottoTicketGeneratorImpl(),
    )
    lottoController.run()
}
