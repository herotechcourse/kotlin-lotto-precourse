package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getPurchaseAmount(): Int {
        return retryUntilValid(::readPurchaseAmount)
    }

    fun getWinningNumbers(): List<Int> {
        return retryUntilValid(::readWinningNumbers)
    }

    fun getBonusNumber(): Int {
        return retryUntilValid(::readBonusNumber)
    }

    private fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount!")
        val amount = Console.readLine().trim()
        return validatePurchaseAmount(amount)
    }

    private fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers (comma-separated):")
        val input = Console.readLine().trim()
        return validateWinningNumbers(input)
    }

    private fun readBonusNumber(): Int {
        println("Please enter the bonus number:")
        val input = Console.readLine().trim()
        return validateBonusNumber(input)
    }

    internal fun validatePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Invalid input. Please enter a valid integer.")
        require(amount >= 1000 && amount % 1000 == 0) {
            "[ERROR] Purchase amount must be a multiple of 1,000."
        }
        return amount
    }

    internal fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be integers.") }

        require(numbers.size == 6) { "[ERROR] Must enter exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Each number must be between 1 and 45." }

        return numbers
    }

    internal fun validateBonusNumber(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be an integer.")
        require(number in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        return number
    }

    private fun <T> retryUntilValid(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}