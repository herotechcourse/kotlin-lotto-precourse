package lotto.util

import lotto.model.PrizeRank

// Utility object to sort PrizeRanks in a specific display order
object PrizeRankSorter {

    // Returns a list of PrizeRanks sorted in the required output order
    fun sort(): List<PrizeRank> {
        return PrizeRank.entries
            .filter { it != PrizeRank.FAIL } // Exclude 'FAIL' since it should not be displayed
            .sortedBy { rank ->
                when (rank) {
                    PrizeRank.FIFTH -> 1
                    PrizeRank.FOURTH -> 2
                    PrizeRank.THIRD -> 3
                    PrizeRank.SECOND -> 4
                    PrizeRank.FIRST -> 5
                    else -> Int.MAX_VALUE // Should not occur
                }
            }
    }
}
