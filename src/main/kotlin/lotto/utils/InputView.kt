package lotto.utils

import camp.nextstep.edu.missionutils.Console

object InputView {
    private fun readInput(): String {
        val input = Console.readLine()
        return validateInputNotEmpty(input)
    }

    internal fun validateInputNotEmpty(input: String?): String {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty.")
        }
        return input
    }

    internal fun toUIntSafe(str: String): UInt {
        return try {
            str.toUInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Number must be between 1 and 4294967295.")
        }
    }

    internal fun validatePurchaseAmount(amount: UInt) {
        if (amount == 0u)
            throw IllegalArgumentException("[ERROR] The purchase amount must be bigger than 0.")
        if (amount % 1000u != 0u)
            throw IllegalArgumentException("[ERROR] The purchase amount must be a multiple of 1000.")
    }

    internal fun toWinningNumbers(str: String): List<Int> {
        val winningNumbers: List<String> = str.split(",")
        return try {
            winningNumbers.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] The input for winning numbers is not valid.")
        }
    }

    internal fun validateWinningNumbers(numbers: List<Int>) {
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

    internal fun toIntSafe(str: String): Int {
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] The input for the bonus number is not valid.")
        }
    }

    internal fun validateBonusNumber(number: Int, winningNumbers: List<Int>) {
        if (number < 1 || number > 45) {
            throw IllegalArgumentException("[ERROR] The bonus number must be between 1 and 45.")
        }
        if (number in winningNumbers) {
            throw IllegalArgumentException("[ERROR] The bonus number must not match any of the winning numbers.")
        }
    }


    /**
     * Note: methods below were manually tested
     * TODO: write integration tests at the end for all methods below
     */

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
        println("Please enter the purchase amount.")
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
        println("Please enter last week's winning numbers.")
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
        println("Please enter the bonus number.")
        val input = readInput()
        val number = toIntSafe(input)
        validateBonusNumber(number, winningNumbers)
        return number
    }
}
