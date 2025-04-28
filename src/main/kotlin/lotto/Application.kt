package lotto

import lotto.controller.LottoController
import lotto.domain.LottoResultChecker
import lotto.domain.LottoTicketIssuer
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoController =
            LottoController(InputView, OutputView, LottoTicketIssuer(), LottoResultChecker())

    lottoController.run()
}
