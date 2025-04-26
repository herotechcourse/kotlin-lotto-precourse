package lotto

class PrizeRankResult(private val statistics: Map<PrizeRank, Int>) {

    fun calculateProfitRate(purchaseAmount: LottoPurchaseAmount): Double {
        val totalPrizeAmount = calculateTotalPrizeAmount()
        return (totalPrizeAmount / purchaseAmount.value) * PERCENTAGE_MULTIPLIER
    }

    private fun calculateTotalPrizeAmount(): Double {
        return statistics.entries.sumOf { (rank, count) -> rank.prizeAmount * count }
            .toDouble()
    }

    fun statistics(): Map<PrizeRank, Int> {
        return statistics.toMap()
    }

    companion object {
        private const val PERCENTAGE_MULTIPLIER: Double = 100.0
    }
}
