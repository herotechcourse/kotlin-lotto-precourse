package lotto.controller

import lotto.Lotto
import lotto.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val amount = InputView.readPurchaseAmount()
        val game = LottoGame()
        val lottos = game.purchase(amount)
        OutputView.printPurchasedLottos(lottos)

        val winningLotto = Lotto(InputView.readWinningNumbers())
        val bonusNumber = InputView.readBonusNumber()

        val result = game.getResult(lottos, winningLotto, bonusNumber)
        OutputView.printWinningStatics(result, amount)
    }
}