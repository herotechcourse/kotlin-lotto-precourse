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
}