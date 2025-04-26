package lotto

import lotto.view.InputView

fun main() {
    val inputView = InputView()
    val purchaseAmount = inputView.getPurchaseAmount()
    val budget = Budget(purchaseAmount)
}
