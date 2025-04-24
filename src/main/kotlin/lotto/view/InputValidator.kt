package lotto.view

class InputValidator {

    // Utility function to handle toIntOrNull() conversion
    private fun String.toValidInt(): Int {
        return this.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number format")
    }

    fun validatePurchaseAmount(input: String): Int {
        val amount = input.toValidInt()
        // Validate purchase amount: must be a positive number divisible by 1000
        return amount.takeIf { it > 0 && it % 1000 == 0 }
            ?: throw IllegalArgumentException("[ERROR] Purchase amount must be a positive number divisible by 1000")
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toValidInt() }

        // Validate that there are exactly 6 winning numbers, they are unique, and within the range of 1-45
        require(numbers.size == 6) { "[ERROR] There must be exactly 6 winning numbers" }
        require(numbers.toSet().size == 6) { "[ERROR] Winning numbers must be unique" }
        require(numbers.all { it in 1..45 }) { "[ERROR] Numbers must be between 1 and 45" }

        return numbers
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        val bonus = input.toValidInt()

        // Validate bonus number: must be between 1-45 and not duplicate any of the winning numbers
        require(bonus in 1..45) { "[ERROR] Bonus number must be between 1 and 45" }
        require(bonus !in winningNumbers) { "[ERROR] Bonus number must not duplicate winning numbers" }

        return bonus
    }
}
