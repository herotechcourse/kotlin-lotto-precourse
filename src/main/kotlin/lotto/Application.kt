package lotto

import lotto.controller.LottoController
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoMachine = LottoController(InputView(), OutputView(), LottoService())
    lottoMachine.run()
}
