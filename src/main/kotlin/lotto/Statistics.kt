package lotto

class Statistics {
    private val rankCounts = mutableMapOf<Rank, Int>().withDefault { 0 }
    private var totalWinnings = 0L

    fun addResult(rank: Rank) {
        rankCounts[rank] = rankCounts.getValue(rank) + 1
        totalWinnings += rank.prize
    }

    val profitRate: String
        get() {
            val totalSpent = rankCounts.values.sum() * 1000
            if (totalSpent == 0) return "0.0"
            val rate = (totalWinnings.toDouble() / totalSpent) * 100
            return "%.1f".format(rate)
        }

    fun getCount(rank: Rank): Int = rankCounts.getValue(rank)
}