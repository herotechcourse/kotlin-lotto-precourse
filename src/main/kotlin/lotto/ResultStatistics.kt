package lotto

class ResultStatistics {
    private val counts = mutableMapOf<Rank, Int>().withDefault { 0 }

    fun increment(rank: Rank) {
        counts[rank] = counts.getValue(rank) + 1
    }

    fun getCount(rank: Rank): Int =
        counts.getValue(rank)

    fun totalPrize(): Long =
        Rank.values().sumOf { getCount(it) * it.prize }

    fun profitRate(purchaseAmount: Int): Double =
        totalPrize() * 100.0 / purchaseAmount
}
