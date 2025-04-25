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
            throw IllegalArgumentException("[ERROR] Invalid input for winning numbers.")
        }
    }
}
