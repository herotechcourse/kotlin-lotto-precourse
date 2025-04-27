package lotto.domain

import lotto.Lotto

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must be exactly 6." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must be unique." }
    }

    fun match(lotto: Lotto): Pair<Int, Boolean> {
        val matchCount = lotto.matchCount(winningNumbers)
        val bonusMatch = lotto.containsBonus(bonusNumber)
        return Pair(matchCount, bonusMatch)
    }
}