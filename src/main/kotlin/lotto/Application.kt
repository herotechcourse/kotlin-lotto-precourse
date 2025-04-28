package lotto

import lotto.view.InputView
import lotto.view.OutputView
fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoIssuer = LottoIssuer()
    val lottos = lottoIssuer.issueLottos(purchaseAmount)

    OutputView.printLottos(lottos)

    val winningNumbers = InputView.getWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()

    val winningResult = WinningResult(winningNumbers, bonusNumber)
    val matchResult = winningResult.match(lottos)
    val totalPrize = winningResult.calculateTotalPrize(matchResult)
    val profitRate = winningResult.calculateProfitRate(totalPrize, purchaseAmount)

    OutputView.printStatistics(matchResult, profitRate)
}
