package lotto.domain

/**
 *  [ Background ]
 *  1. Map <Rank, Int>
 *      rankCounts {
 *          FIRST = 1,
 *          SECOND = 2,
 *          THIRD = 3,
 *          FOURTH = 4,
 *          FIFTH = 5,
 *          MISS = 0
 *      }
 *
 *  2. map.eachCount()
 *      Counts how many times each item(index) appears in a list.
 *
 *  3. map.getOrDefault()
 *      Returns a default value(0) when extracting a key from a map, if it's empty.
 *
 *  4. map.entries
 *      Extracts all (key, value) pairs from the map as a single Set.
 *
 *  5. SRP
 *      Divide: calcProfitRate() & roundProfitRate()
 */
class MatchResult(ranks: List<Rank>) {
    private val rankCounts: Map<Rank, Int> = ranks.groupingBy { it }.eachCount()

    fun getCount(rank: Rank): Int {
        return rankCounts.getOrDefault(rank, 0)
    }

    fun totalPrize(): Int {
        return rankCounts.entries.sumOf { (winningRank, winningNumberCount) ->
            winningRank.prize * winningNumberCount
        }
    }

    fun calcProfitRate(totalAmount: Int, purchaseAmount: Int): Double {
        return totalAmount.toDouble() / purchaseAmount * 100
    }

    fun roundProfitRate(profit: Double): Double {
        return String.format("%.1f", profit).toDouble()
    }

    fun profitRate(purchaseAmount: Int): Double {
        if (purchaseAmount == 0) {
            return 0.0
        }
        val profit = calcProfitRate(totalPrize(), purchaseAmount)
        return roundProfitRate(profit)
    }
}