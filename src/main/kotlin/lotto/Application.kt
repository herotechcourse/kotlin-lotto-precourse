package lotto

import lotto.utils.InputView.readInput
import lotto.utils.InputView.toIntSafe
import lotto.utils.InputView.toUIntSafe
import lotto.utils.InputView.toWinningNumbers
import lotto.utils.InputView.validateBonusNumber
import lotto.utils.InputView.validatePurchaseAmount
import lotto.utils.InputView.validateWinningNumbers

fun main() {
    val purchaseAmount = readPurchaseAmount()
    val winningNumbers = readWinningNumbers() // TODO: decide whether to use instance of Lotto class
    val bonusNumber = readBonusNumber(winningNumbers)
    val numberOfTickets = (purchaseAmount / 1000u).toInt()
}

// TODO: add below methods, and purchase amount, winning numbers, and bonus number as attributes to another class/object?

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
    validateWinningNumbers(numbers)
    return numbers
}

private fun readBonusNumber(winningNumbers: List<Int>): Int {
    while (true) {
        try {
            return promptAndValidateBonusNumber(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

private fun promptAndValidateBonusNumber(winningNumbers: List<Int>): Int {
    println("Please enter the bonus number.")
    val input = readInput()
    val number = toIntSafe(input)
    validateBonusNumber(number, winningNumbers)
    return number
}
