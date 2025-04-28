package lotto

import lotto.util.Constants.PRICE_PER_LOTTO
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoMachine = LottoMachine()
    val purchaseAmount = InputView.readPurchaseAmount()
    val lottoCount = purchaseAmount / PRICE_PER_LOTTO
    lottoMachine.generateLottos(lottoCount)
    OutputView.printPurchasedLottos(lottoMachine.lottos)
    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)
    val results = lottoMachine.calculateResults(winningNumbers, bonusNumber)
    val roi = lottoMachine.calculateROI(purchaseAmount, results)
    OutputView.printStatistics(results, roi)
}
