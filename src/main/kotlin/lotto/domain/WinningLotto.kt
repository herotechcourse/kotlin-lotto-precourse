package lotto.domain

class WinningLotto(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    init {
        validateWinningNumbers(winningNumbers)
        validateBonusNumber(bonusNumber)
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Exactly 6 winning numbers must be provided.")
        }
        if (numbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be between 1 and 45.")
        }
    }

    private fun validateBonusNumber(number: Int) {
        if (number !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (winningNumbers.contains(number)) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be duplicated with winning numbers.")
        }
    }

    fun getWinningNumbers(): List<Int> = winningNumbers
    fun getBonusNumber(): Int = bonusNumber
}
