package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        try {
            val amount = input.toInt()
            validatePurchaseAmount(amount)
            return amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
    }

    private fun validatePurchaseAmount(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
        }
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be a multiple of 1,000.")
        }
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = parseCommaDelimitedNumbers(input)
        validateWinningNumbers(numbers)
        return numbers
    }

    private fun parseCommaDelimitedNumbers(input: String): List<Int> {
        return try {
            input.split(",").map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter valid numbers.")
        }
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Please enter exactly 6 winning numbers.")
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
        if (numbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must not contain duplicates.")
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        try {
            val bonusNumber = input.toInt()
            validateBonusNumber(bonusNumber, winningNumbers)
            return bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be one of the winning numbers.")
        }
    }
} 