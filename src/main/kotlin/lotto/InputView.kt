package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be a number.")
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()

        try {
            val numbers = input.split(",").map { it.trim().toInt() }
            validateWinningNumbers(numbers)
            return numbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be valid integers.")
        }
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must contain exactly 6 numbers.")
        }
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }
        if (numbers.any { it < 1 || it > 45 }) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println()
        println("Please enter the bonus number.")
        val input = Console.readLine()

        try {
            val bonusNumber = input.toInt()
            validateBonusNumber(bonusNumber, winningNumbers)
            return bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
        }
    }

    private fun validateBonusNumber(number: Int, winningNumbers: List<Int>) {
        if (number < 1 || number > 45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (winningNumbers.contains(number)) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be among the winning numbers.")
        }
    }
}
