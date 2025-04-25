package lotto.util

object InputValidator {

    private const val ERROR_PREFIX = "[ERROR]"

    fun validateAmount(amountInput: String): Int {
        val amount = amountInput.toIntOrNull()
            ?: throw IllegalArgumentException("$ERROR_PREFIX Please enter a valid integer.")

        require(amount >= 1000 && amount % 1000 == 0) {
            "$ERROR_PREFIX Each ticket costs 1,000 KRW. Amount must be divisible by 1,000."
        }

        return amount
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = parseCommaSeparatedIntegers(input)

        require(numbers.size == 6) {
            "$ERROR_PREFIX The winning numbers must contain exactly 6 numbers."
        }

        require(numbers.size == numbers.toSet().size) {
            "$ERROR_PREFIX The winning numbers must not contain duplicates."
        }

        require(numbers.all { it in 1..45 }) {
            "$ERROR_PREFIX Lotto numbers must be between 1 and 45."
        }

        return numbers
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException("$ERROR_PREFIX Please enter a valid bonus number.")

        require(bonus in 1..45) {
            "$ERROR_PREFIX Bonus number must be between 1 and 45."
        }

        require(bonus !in winningNumbers) {
            "$ERROR_PREFIX Bonus number must not be included in winning numbers."
        }

        return bonus
    }

    private fun parseCommaSeparatedIntegers(input: String): List<Int> {
        return input.split(",")
            .map { it.trim() }
            .map {
                it.toIntOrNull()
                    ?: throw IllegalArgumentException("$ERROR_PREFIX All inputs must be integers.")
            }
    }
}