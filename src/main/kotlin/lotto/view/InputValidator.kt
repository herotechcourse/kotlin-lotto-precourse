package lotto.view

object InputValidator {

    fun validatePurchaseAmount(input: String) {
        require(input.isNotBlank()) { "[ERROR] Amount cannot be blank." }
        require(input.all { it.isDigit() }) { "[ERROR] Amount must be numeric." }
        require(!(input.length > 1 && input.startsWith("0"))) { "[ERROR] Amount must not start with 0." }
    }

    fun validateWinningNumbers(input: String) {
        require(input.isNotBlank()) { "[ERROR] Winning numbers input cannot be blank." }
        val numbers = input.split(",").map { it.trim() }
        require(numbers.all { it.all { ch -> ch.isDigit() } }) { "[ERROR] Winning numbers must be numeric." }
        require(numbers.all { !(it.length > 1 && it.startsWith("0")) }) { "[ERROR] Winning numbers must not start with 0." }
    }

    fun validateBonusNumber(input: String) {
        require(input.isNotBlank()) { "[ERROR] Bonus number input cannot be blank." }
        require(input.all { it.isDigit() }) { "[ERROR] Bonus number must be numeric." }
        require(!(input.length > 1 && input.startsWith("0"))) { "[ERROR] Bonus number must not start with 0." }
    }
}
