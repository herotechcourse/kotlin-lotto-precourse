package lotto.domain

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
        return when {
            matchCount == 6 -> Rank.FIRST
            matchCount == 5 && bonusMatch -> Rank.SECOND
            matchCount == 5 -> Rank.THIRD
            matchCount == 4 -> Rank.FOURTH
            matchCount == 3 -> Rank.FIFTH
            else -> Rank.NONE
        }
    }


}