package lotto

class LottoResult {
    private val matchCounts: MutableMap<Rank, Int> = mutableMapOf()

    fun record(rank: Rank) {
        matchCounts[rank] = matchCounts.getOrDefault(rank, 0) + 1
    }

    fun getMatchCounts(): Map<Rank, Int> {
        return matchCounts
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        val totalWinningAmount = matchCounts.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
        return (totalWinningAmount.toDouble() / purchaseAmount) * 100
    }
}