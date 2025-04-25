package lotto

import lotto.utils.InputView.readInput
import lotto.utils.InputView.toUIntSafe
import lotto.utils.InputView.toWinningNumbers
import lotto.utils.InputView.validatePurchaseAmount

fun main() {
    val purchaseAmount = readPurchaseAmount()
    val winningNumbers = readWinningNumbers() // TODO: decide whether to use instance of Lotto class
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

// TODO: manually test whether re-prompting works as soon as validation is implemented
private fun readWinningNumbers(): List<Int> {
    while (true) {
        try {
            return promptAndValidateWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

private fun promptAndValidateWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers.")
    val input = readInput()
    val numbers = toWinningNumbers(input)
    // TODO: validateWinningNumbers(numbers)
    return numbers
}