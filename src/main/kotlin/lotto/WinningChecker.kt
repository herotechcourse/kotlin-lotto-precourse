package lotto

class WinningChecker(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must be exactly 6." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(winningNumbers.size == winningNumbers.distinct().size) { "[ERROR] Winning numbers must be unique." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not be in winning numbers." }
    }
    
    fun checkLotto(lotto: Lotto): LottoResult {
        val matchCount = lotto.matchCount(winningNumbers)
        val hasBonusMatch = lotto.contains(bonusNumber)
        
        return LottoResult.from(matchCount, hasBonusMatch)
    }
}