package lotto

import lotto.view.InputView

fun main() {
    val inputView = InputView()
    val purchaseAmount = inputView.getPurchaseAmount()
    val budget = Budget(purchaseAmount)

    val numbers = inputView.getWinningNumbers()
    val winningNumbers = Lotto(numbers)

    val bonusNumber = inputView.getBonusNumber()
    WinningLotto(winningNumbers, bonusNumber)
}
