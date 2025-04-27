package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoGame = LottoGame(InputView(), OutputView())
    lottoGame.play()
}
