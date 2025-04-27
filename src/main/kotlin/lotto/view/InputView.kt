package lotto.view

import lotto.exception.ExceptionMessage
import lotto.util.Validator
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull()
        if (amount == null) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT_FORMAT.message)
        }
        Validator.validatePurchaseAmount(amount)
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = parseNumbers(input)
        Validator.validateLottoNumbers(numbers)
        return numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("\nPlease enter the bonus number.")
        val input = Console.readLine()
        val bonusNumber = input.toIntOrNull()
        if (bonusNumber == null) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER_RANGE.message)
        }
        Validator.validateBonusNumber(bonusNumber, winningNumbers)
        return bonusNumber
    }

    private fun parseNumbers_(input: String): List<Int> {
        return try {
            input.split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.message)
        }
    }

    private fun parseNumbers(input: String): List<Int> =
        input.split(",").map { token ->
            val num = token.trim().toIntOrNull()
            if (num == null) {
                throw IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.message)
            }
            num
        }
}