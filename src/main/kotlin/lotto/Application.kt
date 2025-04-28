package lotto

import lotto.controller.LottoController
import lotto.service.LottoService
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

fun main() {
    val lottoController = LottoController(
        LottoInputView(), LottoOutputView(),
        LottoService()
    )
    lottoController.run()
}
