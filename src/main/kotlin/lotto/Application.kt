package lotto

import lotto.controller.LottoController
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoService = LottoService()
    val controller = LottoController(inputView, outputView, lottoService)
    controller.run()
}
