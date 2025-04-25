package lotto.validator

object InputValidator {
    private fun validateNonEmpty(input: String, errorMessage: String) {
        if (input.trim().isEmpty()) {
            throw IllegalArgumentException(errorMessage)
        }
    }

    fun validateAmount(input: String): Int {
        validateNonEmpty(input, "[ERROR] Input cannot be empty.")

        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        require(amount > 0 && amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000" }
        
        return amount
    }

    fun validateWinningNumbers(input: String): List<Int> {
        validateNonEmpty(input, "[ERROR] Winning Number cannot be empty.")

        val split = input.split(",").map { it.trim() }
        return split.map {
            it.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] All inputs must be valid numbers.")
        }
    }

    fun validateBonusNumber(input: String): Int {
        validateNonEmpty(input, "[ERROR] Bonus Number cannot be empty.")

        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
    }
}
