package lotto

import lotto.controller.LottoApp
import lotto.model.LottoService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoService = LottoService()
    val inputView = InputView()
    val outputView = OutputView()

    val app = LottoApp(lottoService, inputView, outputView)
    app.run()
}
