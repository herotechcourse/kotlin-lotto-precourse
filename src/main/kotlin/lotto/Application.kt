package lotto

import lotto.validator.InputValidator
import lotto.view.InputView

fun main() {
    val validator = InputValidator()
    val inputView = InputView.InputView(validator)

    val purchaseAmount = inputView.readPurchaseAmount()
    val winningNumbers = inputView.readWinningNumbers()
    val bonusNumber = inputView.readBonusNumber()
}
