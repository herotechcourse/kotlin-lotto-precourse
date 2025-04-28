package lotto

import lotto.controller.LottoController
import lotto.model.generator.AutoLottoNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoController(InputView(), OutputView(), AutoLottoNumberGenerator()).run()
}
