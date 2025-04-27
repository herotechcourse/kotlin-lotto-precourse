package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getPurchaseAmount(): Int = retryUntilInputIsValid { getAndParsePurchaseAmount() }
    fun getWinningNumbers(): List<Int> = retryUntilInputIsValid { getAndParseWinningNumbers() }
    fun getBonusNumber(): Int = retryUntilInputIsValid { getAndParseBonusNumber() }

    private inline fun <T> retryUntilInputIsValid(getValue: () -> T): T {
        while (true) {
            try {
                return getValue()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    private fun getAndParsePurchaseAmount(): Int {
        OutputView.requestPurchaseAmount()
        return Console.readLine().toInt()
    }
    private fun getAndParseWinningNumbers(): List<Int> {
        OutputView.requestWinningNumbers()
        return Console.readLine().split(',').map { it.toInt() }
    }
    private fun getAndParseBonusNumber(): Int {
        OutputView.requestBonusNumber()
        return Console.readLine().toInt()
    }
}