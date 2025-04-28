package lotto.domain

class WinningNumbers(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(winningNumbers.toSet().size == 6) { "[ERROR] Winning numbers must be unique." }
        winningNumbers.forEach {
            require(it in 1..45) { "[ERROR] Winning numbers must be between 1 and 45." }
        }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number must not duplicate winning numbers." }
    }

    companion object {
        fun parse(numbersInput: String, bonusInput: String): WinningNumbers {
            val numbers = numbersInput.split(",").map { token ->
                token.trim().toIntOrNull()
                    ?: throw IllegalArgumentException("[ERROR] Winning numbers must be numeric.")
            }
            val bonus = bonusInput.trim().toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Bonus number must be numeric.")
            return WinningNumbers(numbers, bonus)
        }
    }

    fun getWinningNumbers(): List<Int> = winningNumbers.sorted()
    fun getBonusNumber(): Int = bonusNumber
}
