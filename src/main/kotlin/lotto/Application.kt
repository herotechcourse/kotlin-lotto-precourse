package lotto

import lotto.controller.LottoController
import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoMachine = LottoMachine()
    
    val controller = LottoController(inputView, outputView, lottoMachine)
    controller.run()
}
