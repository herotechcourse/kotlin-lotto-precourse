package lotto

import lotto.view.InputView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    validatePurchaseAmount(purchaseAmount)
}

fun validatePurchaseAmount(amount: Int) {
    if (amount <= 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
    }
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
    }
}
