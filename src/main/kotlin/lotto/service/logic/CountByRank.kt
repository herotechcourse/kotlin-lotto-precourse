package lotto.service.logic
import lotto.domain.Rank

/**
 *  [ Backgroud ]
 *  1. getOrDefault()
 *      Checks whether the key (= rank) exists in the map.
 *      If it exists, returns the current count for that key.
 *      If it doesn't, returns the default value 0.
 */
fun countByRank(ranks: List<Rank>): Map<Rank, Int> {
    val result = mutableMapOf<Rank, Int>()

    for (rank in ranks) {
        val count = result.getOrDefault(rank, 0)
        result[rank] = count + 1
    }
    return result
}