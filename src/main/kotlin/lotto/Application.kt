package lotto

fun main() {
    val inputView = InputView()
    val purchaseAmount = inputView.readValidPurchaseAmount()
    val winningNumbers = inputView.readValidWinningNumbers()
    val bonusNumber = inputView.readValidBonusNumber()
}
