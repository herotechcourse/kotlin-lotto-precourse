package lotto.validator

object InputValidator {

    fun validateAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        require(amount > 0 && amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000" }
        
        return amount
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val split = input.split(",").map { it.trim() }
        return split.map {
            it.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] All inputs must be valid numbers.")
        }
    }

    fun validateBonusNumber(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
    }
}
