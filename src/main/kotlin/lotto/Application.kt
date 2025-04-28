package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    // 1. Reads the purchase amount from the user.
    val purchaseAmount = InputView.readPurchaseAmount()

    // 2. Generates the corresponding number of Lotto tickets.
    val purchasedLottos = purchaseAndPrintLottos(purchaseAmount)

    // 3. Reads the winning numbers and bonus number from the user.
    val winningLotto = readWinningLotto()

    // 4. Calculates the winning statistics based on the purchased tickets and winning numbers.
    val lottoResult = calculateResult(purchaseAmount, purchasedLottos, winningLotto)

    // 5. Prints the final statistics and profit rate.
    OutputView.printResult(lottoResult)
}

/** Purchases lottos based on the amount, prints them, and returns the list. */
private fun purchaseAndPrintLottos(purchaseAmount: Int): List<Lotto> {
    val lottoMachine = LottoMachine(purchaseAmount)
    val purchasedLottos = lottoMachine.getLottos()
    OutputView.printPurchasedLottos(purchasedLottos)
    return purchasedLottos
}

/** Reads winning numbers and bonus number from input and returns a WinningLotto object. */
private fun readWinningLotto(): WinningLotto {
    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)
    return WinningLotto(winningNumbers, bonusNumber)
}

/** Calculates the lotto result and returns the LottoResult object. */
private fun calculateResult(purchaseAmount: Int, purchasedLottos: List<Lotto>, winningLotto: WinningLotto): LottoResult {
    val lottoResult = LottoResult(purchaseAmount)
    lottoResult.calculateStatistics(purchasedLottos, winningLotto)
    return lottoResult
}