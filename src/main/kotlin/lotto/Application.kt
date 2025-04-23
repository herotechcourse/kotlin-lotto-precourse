package lotto

import lotto.input.InputView


fun main() {
    try {
        val purchaseAmount = InputView.readPurchaseAmount()
        println("Purchase amount: $purchaseAmount")

        val winningNumbers = InputView.readWinningNumbers()
        println("Winning numbers: $winningNumbers")

        val bonusNumber = InputView.readBonusNumber(winningNumbers)
        println("Bonus number: $bonusNumber")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }

}
