package lotto

object InputValidator {
    /**
     * Validates the purchase amount to be >= 1000 and divisible by 1000.
     */
    fun validatePurchaseAmount(amount: Int) {
        if (amount < 1000) throw IllegalArgumentException("Amount must be at least 1000.")
        if (amount % 1000 != 0) throw IllegalArgumentException("Amount must be divisible by 1000.")
    }

    /**
     * Parses a comma-separated string into a list of integers.
     * Throws if any value is not a valid integer.
     */
    fun parseWinningNumbers(input: String): List<Int> {
        return input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("All values must be valid integers.")
        }
    }

    /**
     * Validates the winning numbers list.
     * Must contain exactly 6 distinct numbers between 1 and 45.
     */
    fun validateWinningNumbers(numbers: List<Int>): List<Int> {
        if (numbers.size != 6) throw IllegalArgumentException("Exactly 6 numbers must be entered.")
        if (numbers.distinct().size != 6) throw IllegalArgumentException("Numbers must be unique.")
        checkRange(numbers)
        return numbers
    }

    /**
     * Checks that all numbers are within the valid range start to End inclusive.
     */
    fun checkRange(numbers: List<Int>) {
        numbers.forEach {
            if (it !in 1..45) throw IllegalArgumentException("All numbers must be between 1 and 45.")
        }
    }
}
