package lotto

class LottoStatistics(private val ranks: List<Rank>) {

    fun getRankCounts(): Map<Rank, Int> {
        return ranks.groupingBy { it }
            .eachCount()
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        val totalPrize = ranks.sumOf { it.prize }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}
