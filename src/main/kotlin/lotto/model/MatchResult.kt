package lotto.model

import lotto.util.PrizeRank

data class MatchResult(
    val rankCounts: Map<PrizeRank, Int>,
    val totalPrize: Int,
    val purchaseAmount: Int
){
    fun calculateProfitRate(): Double {
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}