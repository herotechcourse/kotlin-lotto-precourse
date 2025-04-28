package lotto.domain

import lotto.util.Rank

class WinningStatics {
    val winningStatics: MutableMap<Rank, Int> = mutableMapOf()
    var prizeSum = 0

    init {
        Rank.entries.forEach { winningStatics[it] = 0 }
    }

    fun updateWinningStatics(matchCount: Int, isMatchedBonusNumber: Boolean) {
        val rank = Rank.updateRankCount(matchCount, isMatchedBonusNumber)
        winningStatics[rank] = winningStatics.getOrDefault(rank, 0) + 1
        prizeSum += rank.prize
    }

    fun getStatics(): Map<Rank, Int> = winningStatics

    fun getTotalPrize(): Int = prizeSum
}