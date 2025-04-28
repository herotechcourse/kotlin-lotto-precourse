package lotto

import lotto.domain.LottoPurchase
import lotto.domain.LottoResult
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    try {
        val purchaseAmount = InputView.getPurchaseAmount()
        val purchase = LottoPurchase.from(purchaseAmount)
        OutputView.printPurchaseResult(purchase)

        val winningNumbers = InputView.getWinningNumbers()
        val bonusNumber = InputView.getBonusNumber(winningNumbers)
        val winningNumbersObj = WinningNumbers.from(winningNumbers, bonusNumber)

        val result = LottoResult.from(purchase.tickets, winningNumbersObj)
        OutputView.printWinningStatistics(result)
        OutputView.printReturnRate(result, purchaseAmount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
