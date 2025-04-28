package lotto.model

class LottoResult {

    private val results: MutableMap<PrizeRank, Int> = mutableMapOf()

    init {
        PrizeRank.entries.forEach { results[it] = 0 }
    }

    fun record(prizeRank: PrizeRank) {
        results[prizeRank] = results.getValue(prizeRank) + 1
    }

    fun getResults(): Map<PrizeRank, Int> {
        return results
    }

    fun getTotalPrizeMoney(): Int {
        return results.entries.sumOf { (rank, count) ->
            rank.prizeMoney * count
        }
    }

    fun calculateProfitRate(totalSpent: Int): Double {
        val totalPrize = getTotalPrizeMoney()
        return (totalPrize.toDouble() / totalSpent) * 100
    }
}
