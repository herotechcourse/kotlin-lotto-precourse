package lotto

import lotto.service.LottoGame
import lotto.service.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoMachine = LottoMachine()
    val inputView = InputView()
    val outputView = OutputView()

    val lottoGame = LottoGame(lottoMachine, inputView, outputView)
    lottoGame.play()
}