package lotto

class WinningLotto(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Winning numbers must not contain bonus number." }

        require(winningNumbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getWinningNumbers(): List<Int> {
        return winningNumbers
    }
    fun getBonusNumber(): Int {
        return bonusNumber
    }
}