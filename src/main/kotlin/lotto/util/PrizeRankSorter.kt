package lotto.util

import lotto.model.PrizeRank

object PrizeRankSorter {

    fun sort(): List<PrizeRank> {
        return PrizeRank.entries
            .filter { it != PrizeRank.FAIL }
            .sortedBy { rank ->
                when (rank) {
                    PrizeRank.FIFTH -> 1
                    PrizeRank.FOURTH -> 2
                    PrizeRank.THIRD -> 3
                    PrizeRank.SECOND -> 4
                    PrizeRank.FIRST -> 5
                    else -> Int.MAX_VALUE
                }
            }
    }
}
