package lotto

import lotto.utils.InputView.readInput
import lotto.utils.InputView.toUIntSafe
import lotto.utils.InputView.validatePurchaseAmount

fun main() {
    val purchaseAmount = readPurchaseAmount()
}

private fun readPurchaseAmount(): UInt {
    while (true) {
        try {
            return promptAndValidatePurchaseAmount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

private fun promptAndValidatePurchaseAmount(): UInt {
    println("Please enter the purchase amount.")
    val input = readInput()
    val amount = toUIntSafe(input)
    validatePurchaseAmount(amount)
    return amount
}