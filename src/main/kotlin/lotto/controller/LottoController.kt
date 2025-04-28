package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.WinningLotto
import lotto.domain.WinningResult
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val lottoGenerator: LottoGenerator
) {
    fun run() {
        try {
            val purchaseAmount = inputView.readPurchaseAmount()
            val lottos = lottoGenerator.generate(purchaseAmount)
            
            resultView.printPurchasedTickets(lottos)
            
            val winningNumbers = inputView.readWinningNumbers()
            val bonusNumber = inputView.readBonusNumber()
            
            val winningLotto = WinningLotto(winningNumbers, bonusNumber)
            val winningResult = WinningResult(lottos, winningLotto)
            
            resultView.printWinningResults(winningResult, purchaseAmount)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
} 