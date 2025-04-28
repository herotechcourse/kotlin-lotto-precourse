package lotto

class WinningLotto(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not duplicate any winning number." }
    }

    fun getWinningNumbers(): List<Int> {
        return winningNumbers.sorted()
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }
}