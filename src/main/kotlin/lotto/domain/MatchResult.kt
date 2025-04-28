package lotto.domain

data class MatchResult(val matchCount: Int, val matchBonusNumber: Boolean) {
    fun getWinningRank(): WinningPrizeRanks {
        return when (matchCount) {
            6 -> WinningPrizeRanks.FIRST
            5 -> if (matchBonusNumber) WinningPrizeRanks.SECOND else WinningPrizeRanks.THIRD
            4 -> WinningPrizeRanks.FOURTH
            3 -> WinningPrizeRanks.FIFTH
            else -> WinningPrizeRanks.NONE
        }
    }
}
