package lotto

import lotto.controller.LottoController
import lotto.domain.LottoGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoController = LottoController(
        InputView(),
        ResultView(),
        LottoGenerator()
    )
    
    lottoController.run()
}
