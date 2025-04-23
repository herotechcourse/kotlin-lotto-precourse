package lotto.validator

object InputValidator {

    fun validateAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        require(amount > 0 && amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000" }
        return amount
    }
}
