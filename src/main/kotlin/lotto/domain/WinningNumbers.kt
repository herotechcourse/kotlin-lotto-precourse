package lotto.domain

class WinningNumbers private constructor(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    companion object {
        fun parse(numbersInput: String, bonusInput: String): WinningNumbers {
            val tokens = numbersInput.split(",")
            require(tokens.size == 6) {
                "[ERROR] Winning numbers must contain exactly 6 numbers."
            }

            val numbers = tokens.map { token ->
                token.trim().toIntOrNull()
                    ?: throw IllegalArgumentException("[ERROR] Winning numbers must be numeric.")
            }

            require(numbers.all { it in 1..45 }) {
                "[ERROR] Winning numbers must be between 1 and 45."
            }

            val bonus = bonusInput.trim().toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Bonus number must be numeric.")
            require(bonus in 1..45) {
                "[ERROR] Bonus number must be between 1 and 45."
            }

            require(!numbers.contains(bonus)) {
                "[ERROR] Bonus number must not duplicate winning numbers."
            }

            return WinningNumbers(numbers, bonus)
        }
    }

    fun getWinningNumbers(): List<Int> = winningNumbers.sorted()
    fun getBonusNumber(): Int = bonusNumber
}
