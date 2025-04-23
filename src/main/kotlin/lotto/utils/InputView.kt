package lotto.utils

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

object InputView {
    fun readPurchaseAmount(): Int {

        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be empty.")
                return parsePurchaseAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: NumberFormatException) {
                println("[ERROR] Input must be a number.")
            }
        }
    }

    internal fun parsePurchaseAmount(input: String): Int {

        require(input.isNotBlank()) { "[ERROR] Input cannot be empty." }
        val amount = input.toIntOrNull() ?: throw NumberFormatException("[ERROR] Input must be a number.")
        require(amount > 0) { "[ERROR] The purchase amount must be greater than 0." }
        require(amount % 1000 == 0) { "[ERROR] The purchase amount must be divisible by 1,000." }

        return amount
    }

    fun readWinningTicket(): Lotto{

        while (true) {
            try {
                println("Please enter last week's winning numbers (comma-separated).")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be empty.")
                val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must contain 6 numbers.") }
                return parseWinningTicket(numbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun parseWinningTicket(numbers: List<Int>): Lotto {
        require(numbers.size == 6) { "[ERROR] Winning numbers must be 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }

        return Lotto(numbers)
    }

}