package lotto.model

class LottoResult {

    // Stores the number of wins per PrizeRank
    private val results: MutableMap<PrizeRank, Int> = mutableMapOf()

    // Initialize all PrizeRanks with a count of 0
    init {
        PrizeRank.entries.forEach { results[it] = 0 }
    }

    // Records a win for the given PrizeRank
    fun record(prizeRank: PrizeRank) {
        results[prizeRank] = results.getValue(prizeRank) + 1
    }

    // Returns the current result map (read-only)
    fun getResults(): Map<PrizeRank, Int> {
        return results
    }

    // Calculates the total prize money based on the results
    fun getTotalPrizeMoney(): Int {
        return results.entries.sumOf { (rank, count) ->
            rank.prizeMoney * count
        }
    }

    // Calculates the profit rate (return rate) based on total spending
    fun calculateProfitRate(totalSpent: Int): Double {
        val totalPrize = getTotalPrizeMoney()
        return (totalPrize.toDouble() / totalSpent) * 100
    }
}
