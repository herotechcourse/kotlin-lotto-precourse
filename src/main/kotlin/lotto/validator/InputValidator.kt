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
        val numbers = split.map {
            it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] All inputs must be valid numbers.")
        }
    
        require(numbers.size == 6) { "[ERROR] There must be exactly 6 winning numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must not contain duplicates." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Numbers must be between 1 and 45." }
    
        return numbers
    }


    fun validateBonusNumber(input: String): Int {
        validateNonEmpty(input, "[ERROR] Bonus Number cannot be empty.")

        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
    }
}
