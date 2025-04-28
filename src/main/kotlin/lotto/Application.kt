package lotto

import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val amount = takePayment()
    val lottoBundle = issueLottoBundle(amount)
    OutputView.printPurchasedLotto(lottoBundle)

    val winningLotto = takeWinningNumbers()
    val result = getLottoResult(lottoBundle, winningLotto)
    OutputView.printStatistics(result)
    OutputView.printProfitRate(result, amount)
}

private fun takePayment(): Int {
    val purchaseAmount = retryable {
        InputView.showInstruction("Please enter the purchase amount.")
        InputView.readPurchaseAmount()
    }
    return purchaseAmount
}

private fun issueLottoBundle(amount: Int): List<Lotto> {
    val machine = LottoMachine()
    return machine.issueBundle(amount)
}

private fun takeWinningNumbers(): WinningLotto {
    val winningNumbers = retryable {
        InputView.showInstruction("\nPlease enter last week's winning numbers.")
        InputView.readWinningNumbers()
    }
    val bonusNumber = retryable {
        InputView.showInstruction("\nPlease enter the bonus number.")
        InputView.readBonusNumber(winningNumbers)
    }
    return WinningLotto(winningNumbers, bonusNumber)
}

private fun getLottoResult(lottoBundle: List<Lotto>, winningLotto: WinningLotto): LottoResult {
    val result = LottoResult()
    lottoBundle.forEach { lotto ->
        val rank = winningLotto.match(lotto)
        result.add(rank)
    }
    return result
}

private fun <T> retryable(inputMethod: () -> T): T {
    while (true) {
        try {
            return inputMethod()
        } catch (err: IllegalArgumentException) {
            println("${err.message}")
        }
    }
}