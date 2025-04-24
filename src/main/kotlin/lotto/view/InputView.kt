package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun requestPurchaseAmount(): Int {
        println("Please enter the purchase amount for lottery tickets:")
        return retryUntilValid(::parseAmount)
    }

    fun requestWinningNumbers(): List<Int> {
        println("Please enter the winning numbers (comma-separated):")
        return retryUntilValid(::parseWinningNumbers)
    }

    fun requestBonusNumber(): Int {
        println("Please enter the bonus number:")
        return retryUntilValid(::parseBonusNumber)
    }

    private inline fun <T> retryUntilValid(parse: (String) -> T): T {
        while (true) {
            val input = Console.readLine()?.trim() ?: continue
            runCatching { return parse(input) }
                .onFailure { println(it.message) }
        }
    }

    private fun parseAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be a number.")
        require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000." }
        return amount
    }

    private fun parseWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be valid integers.")
        }

        require(numbers.size == 6 && numbers.all { it in 1..45 }) {
            "[ERROR] Winning numbers must be 6 numbers between 1 and 45."
        }
        return numbers
    }

    private fun parseBonusNumber(input: String): Int {
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be a valid integer.")
        require(number in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        return number
    }
}
