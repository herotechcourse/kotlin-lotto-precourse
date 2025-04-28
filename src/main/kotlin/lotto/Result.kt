package lotto

data class Result(
    val rankCounts: Map<Rank, Int>,
    val purchaseAmount: Int,
) {
    private fun totalPrize(): Long {
        return rankCounts.entries.sumOf { (rank, count) -> rank.prize.toLong() * count }
    }

    fun profitRate(): Double {
        return totalPrize().toDouble() / purchaseAmount * 100
    }
}