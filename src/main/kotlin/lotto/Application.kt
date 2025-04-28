package lotto

import lotto.controller.LottoController
import lotto.view.InputView
import lotto.view.OutputView
import lotto.controller.CreateController

fun main() {
    LottoController(InputView(), OutputView(), CreateController()).run()    
}
