package lotto

object InputValidator {
    fun validateWinningNumbersInput(input: String) {
        require(input.isNotBlank()) { "[ERROR] Input must not be blank." }

        val rawNumbers = input.split(",").map { it.trim() }

        require(rawNumbers.all { it.isNotBlank() }) { "[ERROR] Winning numbers must not contain blank values." }
        require(rawNumbers.all { it.toIntOrNull() != null }) { "[ERROR] Winning numbers must be integers." }

    }

    fun validateBonusNumberInput(input: String) {
        require(input.isNotBlank()) { "[ERROR] Bonus number must not be blank." }

        val bonusNumber = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be an integer.")
    }

    fun validatePurchaseAmount(input: String) {
        val cleanedInput = input.replace(",", "").trim()
        require(cleanedInput.isNotBlank()) { "[ERROR] Purchase amount cannot be blank." }

        val purchaseAmount = cleanedInput.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Purchase amount must be an integer without decimal points.")

        require(purchaseAmount >= 1000) { "[ERROR] Purchase amount must be at least 1,000 KRW." }
        require(purchaseAmount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
    }
}