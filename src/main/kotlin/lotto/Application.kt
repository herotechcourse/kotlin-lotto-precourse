package lotto

import lotto.controller.LottoController
import lotto.presentation.InputViewImpl
import lotto.presentation.OutputViewImpl
import lotto.utils.InputValidatorImpl
import lotto.utils.LottoTicketGeneratorImpl

fun main() {
    val lottoController = LottoController(
        inputView = InputViewImpl(),
        inputValidator = InputValidatorImpl(),
        outputView = OutputViewImpl(),
        lottoTicketGenerator = LottoTicketGeneratorImpl(),
    )
    lottoController.run()
}
