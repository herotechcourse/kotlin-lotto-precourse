package lotto.utils

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val ERROR_PREFIX = "[ERROR] "
    private const val EMPTY_INPUT_ERROR = "${ERROR_PREFIX}Input cannot be empty."
    private const val INVALID_NUMBER_ERROR = "${ERROR_PREFIX}Number must be between 1 and 4294967295."
    private const val ZERO_AMOUNT_ERROR = "${ERROR_PREFIX}The purchase amount must be bigger than 0."
    private const val NOT_MULTIPLE_ERROR = "${ERROR_PREFIX}The purchase amount must be a multiple of 1000."
    private const val INVALID_WINNING_NUMBERS_ERROR = "${ERROR_PREFIX}The input for winning numbers is not valid."
    private const val SIX_NUMBERS_ERROR = "${ERROR_PREFIX}There must be exactly six winning numbers."
    private const val NUMBERS_RANGE_ERROR = "${ERROR_PREFIX}The winning numbers must be between 1 and 45."
    private const val NUMBERS_UNIQUE_ERROR = "${ERROR_PREFIX}The winning numbers must be unique."
    private const val INVALID_BONUS_ERROR = "${ERROR_PREFIX}The input for the bonus number is not valid."
    private const val BONUS_RANGE_ERROR = "${ERROR_PREFIX}The bonus number must be between 1 and 45."
    private const val BONUS_UNIQUE_ERROR = "${ERROR_PREFIX}The bonus number must not match any of the winning numbers."

    private const val PROMPT_PURCHASE_AMOUNT = "Please enter the purchase amount."
    private const val PROMPT_WINNING_NUMBERS = "Please enter last week's winning numbers."
    private const val PROMPT_BONUS_NUMBER = "Please enter the bonus number."

    private fun readInput(): String {
        val input = Console.readLine()
        return validateInputNotEmpty(input)
    }

    internal fun validateInputNotEmpty(input: String?): String {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(EMPTY_INPUT_ERROR)
        }
        return input
    }

    internal fun toUIntSafe(str: String): UInt {
        return try {
            str.toUInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_NUMBER_ERROR)
        }
    }

    internal fun validatePurchaseAmount(amount: UInt) {
        if (amount == 0u)
            throw IllegalArgumentException(ZERO_AMOUNT_ERROR)
        if (amount % 1000u != 0u)
            throw IllegalArgumentException(NOT_MULTIPLE_ERROR)
    }

    internal fun toWinningNumbers(str: String): List<Int> {
        val winningNumbers: List<String> = str.split(",")
        return try {
            winningNumbers.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_WINNING_NUMBERS_ERROR)
        }
    }

    internal fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(SIX_NUMBERS_ERROR)
        }
        if (!numbers.all { it in 1..45 }) {
            throw IllegalArgumentException(NUMBERS_RANGE_ERROR)
        }
        if (numbers.toSet().size != 6) {
            throw IllegalArgumentException(NUMBERS_UNIQUE_ERROR)
        }
    }

    internal fun toIntSafe(str: String): Int {
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_BONUS_ERROR)
        }
    }

    internal fun validateBonusNumber(number: Int, winningNumbers: List<Int>) {
        if (number < 1 || number > 45) {
            throw IllegalArgumentException(BONUS_RANGE_ERROR)
        }
        if (number in winningNumbers) {
            throw IllegalArgumentException(BONUS_UNIQUE_ERROR)
        }
    }

    fun readPurchaseAmount(): UInt {
        while (true) {
            try {
                return promptAndValidatePurchaseAmount()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun promptAndValidatePurchaseAmount(): UInt {
        println(PROMPT_PURCHASE_AMOUNT)
        val input = readInput()
        val amount = toUIntSafe(input)
        validatePurchaseAmount(amount)
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                return promptAndValidateWinningNumbers()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun promptAndValidateWinningNumbers(): List<Int> {
        println(PROMPT_WINNING_NUMBERS)
        val input = readInput()
        val numbers = toWinningNumbers(input)
        validateWinningNumbers(numbers)
        return numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                return promptAndValidateBonusNumber(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun promptAndValidateBonusNumber(winningNumbers: List<Int>): Int {
        println(PROMPT_BONUS_NUMBER)
        val input = readInput()
        val number = toIntSafe(input)
        validateBonusNumber(number, winningNumbers)
        return number
    }
}
