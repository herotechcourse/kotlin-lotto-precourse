package lotto.controller

import lotto.domain.LottoResult
import lotto.domain.LottoesGenerator
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoGameController {

    fun run() {
        val purchaseAmount = InputView.readPurchaseAmount()
        val lottoes = LottoesGenerator.generate(purchaseAmount)
        OutputView.printLottoes(lottoes)

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber(winningNumbers)

        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val result = LottoResult.of(lottoes, winningLotto)

        OutputView.printResult(result, purchaseAmount)
    }
}