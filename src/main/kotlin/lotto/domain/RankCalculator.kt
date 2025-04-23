package lotto.domain

import lotto.Lotto

object RankCalculator {
    fun calculate(lotto: Lotto, winningNumbers: WinningNumbers): Rank {
        val matchCount = lotto.matchCount(winningNumbers.numbers)
        val hasBonus = lotto.containsNumber(winningNumbers.bonusNumber)

        return when {
            matchCount == 6 -> Rank.FIFTH
            matchCount == 5 && hasBonus -> Rank.FOURTH
            matchCount == 5 -> Rank.THIRD
            matchCount == 4 -> Rank.SECOND
            matchCount == 3 -> Rank.FIRST
            else -> Rank.NONE
        }
    }
}