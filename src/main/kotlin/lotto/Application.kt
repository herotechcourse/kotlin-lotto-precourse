package lotto

import lotto.controller.LottoController
import lotto.domain.LottoGenerator
import lotto.domain.LottoRanker
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val controller = LottoController(InputView, OutputView, LottoGenerator, LottoRanker())

    controller.run()
}
