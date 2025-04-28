package lotto

import lotto.view.InputView

fun main() {
    println("Please enter the purchase amount.")
    val amount = InputView.readPurchaseAmount()

    println("Please enter the winning numbers (comma-separated).")
    val winning = InputView.readWinningNumbers()

    println("Please enter the bonus number.")
    val bonus = InputView.readBonusNumber()

    // TODO: implement core logic and call OutputView to display results
}
