package lotto.validator

/**
 * Validates raw user inputs for the Lotto game.
 */
class InputValidator : Validator {

    /**
     * Validates purchase amount string and returns integer.
     * @throws IllegalArgumentException on non-numeric or not divisible by 1000.
     */
    override fun validatePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        }
        if (amount <= 0) {
            throw IllegalArgumentException("[ERROR] Amount must be greater than 0.")
        }

        return amount
    }

    /**
     * Validates winning numbers string and returns list of 6 unique ints in 1..45.
     * @throws IllegalArgumentException on invalid format, duplicates, or out-of-range.
     */
    override fun validateWinningNumbers(input: String): List<Int> {
        val nums = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid winning numbers.") }
        if (nums.size != 6 || nums.toSet().size != 6 || nums.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers between 1 and 45.")
        }

        return nums
    }

    /**
     * Validates bonus number string and returns int in 1..45.
     * @throws IllegalArgumentException on invalid format or out-of-range.
     */
    override fun validateBonusNumber(input: String): Int {
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
        if (bonus !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }

        return bonus
    }
}
