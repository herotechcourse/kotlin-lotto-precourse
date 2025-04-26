package lotto

class PrizeRankResult(val statistics: Map<PrizeRank, Int>) {

    fun calculateProfitRate(purchaseAmount: Int): Double {
        return (getTotalPrizeAmount() / purchaseAmount) * PERCENTAGE_MULTIPLIER
    }

    private fun getTotalPrizeAmount(): Double {
        return statistics.entries.sumOf { (rank, count) -> rank.prizeAmount * count }
            .toDouble()
    }

    companion object {
        private const val PERCENTAGE_MULTIPLIER: Double = 100.0
    }
}
