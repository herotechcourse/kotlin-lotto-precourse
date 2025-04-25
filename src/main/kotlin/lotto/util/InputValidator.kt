package lotto.util

object InputValidator {

    fun parseAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be a number.")
        require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000." }
        return amount
    }

    fun parseWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be valid integers.")
        }

        require(numbers.size == 6 && numbers.all { it in 1..45 }) {
            "[ERROR] Winning numbers must be 6 numbers between 1 and 45."
        }
        return numbers
    }

    fun parseBonusNumber(input: String): Int {
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be a valid integer.")
        require(number in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        return number
    }
}

