package lotto

object BonusNumberValidator {
    fun validate(input: String, winningNumbers: List<Int>) {
        require(input.isNotBlank()) { "[ERROR] Bonus number must not be blank." }

        val bonusNumber = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be an integer.")

        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not overlap with winning numbers." }
    }
}