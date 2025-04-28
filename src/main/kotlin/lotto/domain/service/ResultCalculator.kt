package lotto.domain.service

import lotto.Lotto
import lotto.domain.model.*

class ResultCalculator {
    private fun calculateSingleMatch(lotto: Lotto, winningNumber: WinningNumber): Int {
        return lotto.matchCount(winningNumber.numbers)
    }

    private fun isBonusNumberMatch(lotto: Lotto, bonusNumber: BonusNumber): Boolean {
        return lotto.containsSingleNumber(bonusNumber.number)
    }

    fun calculateTotalMatch(lotties: Lotties, winningNumbers: WinningNumbers): WinResult {
        val result = WinResult()

        for (lotto in lotties.value) {
            val matchCount = calculateSingleMatch(lotto, winningNumbers.winningNumber)
            val bonusMatch = isBonusNumberMatch(lotto, winningNumbers.bonusNumber)
            val rank = determineRank(matchCount, bonusMatch)
            result.updateResult(rank)
        }

        return result
    }

    private fun determineRank(matchCount: Int, bonusMatch: Boolean): Rank {
        if (matchCount == 6) return Rank.FIRST
        if (matchCount == 5) return if (bonusMatch) Rank.SECOND else Rank.THIRD
        return when (matchCount) {
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.NONE
        }
    }
}