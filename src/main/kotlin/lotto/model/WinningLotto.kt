package lotto.model

import lotto.Lotto

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    fun match(userLotto: Lotto): PrizeTier {
        val matchCount = userLotto.countMatch(winningNumbers)
        val hasBonusMatch = userLotto.contains(bonusNumber)

        return PrizeTier.calculate(matchCount, hasBonusMatch)
    }
}