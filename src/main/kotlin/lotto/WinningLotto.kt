package lotto

class WinningLotto(
    private val winningNumbers: Lotto,
    private val bonusNumber: Int
) {
    init {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!winningNumbers.matchNumbers().contains(bonusNumber)) { "[ERROR] Winning numbers must not contain bonus number." }

        require(winningNumbers.matchNumbers().size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(winningNumbers.matchNumbers().distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(winningNumbers.matchNumbers().all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }
}