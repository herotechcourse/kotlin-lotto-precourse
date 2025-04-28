package lotto

import lotto.controller.LottoController

fun main() {
    LottoController(InputView(), OutputView(), CreateController()).run()    
}
