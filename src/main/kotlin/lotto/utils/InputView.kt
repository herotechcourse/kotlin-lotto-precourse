package lotto.utils

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readInput(): String {
        val input = readLineSafe()
        return validateInputNotEmpty(input)
    }

    private fun readLineSafe(): String? {
        return try {
            Console.readLine()
        } catch (e: NoSuchElementException) {
            null
        }
    }

    internal fun validateInputNotEmpty(input: String?): String {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty.")
        }
        return input
    }

    fun toUIntSafe(str: String): UInt {
        return try {
            str.toUInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Number must be between 1 and 4294967295.")
        }
    }

    fun validatePurchaseAmount(amount: UInt) {
        if (amount == 0u)
            throw IllegalArgumentException("[ERROR] The purchase amount must be bigger than 0.")
        if (amount % 1000u != 0u)
            throw IllegalArgumentException("[ERROR] The purchase amount must be a multiple of 1000.")
    }

    fun toWinningNumbers(str: String): List<Int> {
        val winningNumbers: List<String> = str.split(",")
        return try {
            winningNumbers.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] The input for winning numbers is not valid.")
        }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] There must be exactly six winning numbers.")
        }
        if (!numbers.all { it in 1..45 }) {
            throw IllegalArgumentException("[ERROR] The winning numbers must be between 1 and 45.")
        }
        if (numbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] The winning numbers must be unique.")
        }
    }

    fun toIntSafe(str: String): Int {
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] The input for the bonus number is not valid.")
        }
    }

    fun validateBonusNumber(number: Int, winningNumbers: List<Int>) {
        if (number < 1 || number > 45) {
            throw IllegalArgumentException("[ERROR] The bonus number must be between 1 and 45.")
        }
        if (number in winningNumbers) {
            throw IllegalArgumentException("[ERROR] The bonus number must not match any of the winning numbers.")
        }
    }
}
