package lotto

object InputValidator {
    /**
     * Validates the purchase amount to be >= 1000 and divisible by 1000.
     */
    fun validatePurchaseAmount(amount: Int) {
        if (amount < 1000) throw IllegalArgumentException("[ERROR] Amount must be at least 1000.")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
    }

    /**
     * Parses a comma-separated string into a list of integers.
     * Throws if any value is not a valid integer.
     */
    fun parseWinningNumbers(input: String): List<Int> {
        return input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] All values must be valid integers.")
        }
    }

    /**
     * Validates the winning numbers list.
     * Must contain exactly 6 distinct numbers between 1 and 45.
     */
    fun validateWinningNumbers(numbers: List<Int>): List<Int> {
        if (numbers.size != 6) throw IllegalArgumentException("[ERROR] Exactly 6 numbers must be entered.")
        if (numbers.distinct().size != 6) throw IllegalArgumentException("[ERROR] Numbers must be unique.")
        checkRange(numbers)
        return numbers
    }

    /**
     * Checks that all numbers are within the valid range start to End inclusive.
     */
    private fun checkRange(numbers: List<Int>) {
        numbers.forEach {
            if (it !in 1..45) throw IllegalArgumentException("[ERROR] All numbers must be between 1 and 45.")
        }
    }

    /**
     * Validates that the bonus number is a valid integer in the range 1–45.
     */
    fun validateBonusNumber(input: String): Int {
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        if (number !in 1..45) throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        return number
    }
}
