package lotto.utils

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

object InputView {
    fun readPurchaseAmount(): Int {
        return readUntilValid("Please enter the purchase amount.") {
            val input = Console.readLine()?: throw IllegalArgumentException("[ERROR] Input cannot be empty.")
            parsePurchaseAmount(input)
        }
    }

    internal fun parsePurchaseAmount(input: String): Int {

        require(input.isNotBlank()) { "[ERROR] Input cannot be empty." }
        val amount = input.toIntOrNull() ?: throw NumberFormatException("[ERROR] Input must be a number.")
        require(amount > 0) { "[ERROR] The purchase amount must be greater than 0." }
        require(amount % 1000 == 0) { "[ERROR] The purchase amount must be divisible by 1,000." }

        return amount
    }

    fun readWinningTicket(): Lotto {
        return readUntilValid("\nPlease enter last week's winning numbers (comma-separated).") {
            val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be empty.")
            val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must contain valid numbers.") }
            parseWinningTicket(numbers)
        }
    }

    internal fun parseWinningTicket(numbers: List<Int>): Lotto {
        require(numbers.size == 6) { "[ERROR] Winning numbers must be 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }

        return Lotto(numbers)
    }

    fun readBonusNumber(winningNumbers: Lotto): Int {
        return  readUntilValid("\nPlease enter last week's bonus number.") {
            val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be empty.")
            parseBonusNumber(input, winningNumbers)
        }
    }


    internal fun parseBonusNumber(input: String, winningNumbers: Lotto): Int {
        require(input.isNotBlank()) { "[ERROR] Input cannot be empty." }
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        require(number !in winningNumbers.getNumbers()) { "[ERROR] Bonus number must not be among the winning numbers." }
        require(number in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        return number
    }

    // Helper function that repeatedly prompts the user for input until a valid value is provided.
    // @param prompt The message displayed to the user.
    // @param parse A lambda that parses and validates the input, throwing an exception if invalid.
    // @return A valid parsed value of type [T].

    private fun <T> readUntilValid(prompt: String, parse: () -> T): T {

        while (true) {
            try {
                println(prompt)
                return parse()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: NumberFormatException) {
                println("[ERROR] Input must be a number.")
            }
        }
    }
}