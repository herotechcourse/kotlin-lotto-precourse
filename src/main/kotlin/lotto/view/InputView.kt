package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        try {
            val amount = input.toInt()
            return amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid integer amount.")
        }
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()

        return parseWinningNumbers(input)
    }

    private fun parseWinningNumbers(input: String): List<Int> {
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
            throw IllegalArgumentException("[ERROR] You must enter exactly 6 winning numbers.")
        }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()

        try {
            return input.trim().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Bonus number must be a valid integer.")
        }
    }
}