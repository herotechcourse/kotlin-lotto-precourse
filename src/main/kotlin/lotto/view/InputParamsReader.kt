package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.PurchaseAmountValidator

class InputParamsReader {
    private val validator = PurchaseAmountValidator()

    fun retrievePurchaseAmountWithRetry(): Int {
        println("Please enter the purchase amount.")
        while (true) {
            try {
                return retrievePurchaseAmount()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun retrieveLastWeekWinningNumbersWithRetry(): List<Int> {
        println("Please enter last week's winning numbers.")
        while (true) {
            try {
                return retrieveLastWeekWinningNumbers()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun retrieveBonusNumberWithRetry(lastWeekWinningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        while (true) {
            try {
                return retrieveBonusNumber(lastWeekWinningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun retrieveBonusNumber(lastWeekWinningNumbers: List<Int>): Int {
        val input = Console.readLine()
        val bonusNumber = input.toIntOrNull()
        validator.validateBonusNumber(bonusNumber, lastWeekWinningNumbers)
        return bonusNumber!!
    }

    private fun retrieveLastWeekWinningNumbers(): List<Int> {
        val input = Console.readLine()
        val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        validator.validateWinningNumbers(numbers)
        return numbers
    }

    private fun retrievePurchaseAmount(): Int {
        val input = Console.readLine()
        val amount = input.toIntOrNull()
        validator.validatePurchaseAmount(amount)
        return amount!!
    }
}