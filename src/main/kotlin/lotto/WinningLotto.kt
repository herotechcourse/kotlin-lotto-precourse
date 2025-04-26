package lotto

class WinningLotto (
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int) {

    init {
        require(winningNumbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(winningNumbers.size != winningNumbers.distinct().size) { "[ERROR] Lotto numbers must be unique." }
        require(bonusNumber in 1..45) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(winningNumbers.none { it == bonusNumber }) { "[ERROR] Lotto numbers must be unique." }
    }
}