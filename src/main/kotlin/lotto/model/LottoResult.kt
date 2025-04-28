package lotto.model

class LottoResult {
    private val rankCounts: MutableMap<Rank, Int> = mutableMapOf()

    init {
        Rank.values().forEach { rank ->
            rankCounts[rank] = 0
        }
    }

    fun addRank(rank: Rank) {
        rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
    }

    fun getRankCount(rank: Rank): Int {
        return rankCounts.getOrDefault(rank, 0)
    }

    fun getTotalPrize(): Long {
        return rankCounts.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        if (purchaseAmount <= 0) {
            return 0.0
        }

        val totalPrize = getTotalPrize()
        return totalPrize * 100.0 / purchaseAmount
    }
}