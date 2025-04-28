package lotto.model

class WinningLotto(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not be duplicate with winning numbers." }
    }

    fun match(lotto: Lotto): Rank {
        val matchCount = lotto.matchCount(winningNumbers)
        val hasBonus = lotto.contains(bonusNumber)

        return Rank.valueOf(matchCount, hasBonus)
    }

    fun getWinningNumbers(): List<Int> {
        return winningNumbers.sorted()
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }
}