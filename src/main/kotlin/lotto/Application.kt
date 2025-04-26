package lotto

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val service = LottoService(inputView, outputView)
    service.processing()
}