package lotto.domain

/**
 * Represents the different prize ranks in the lottery.
 * Each rank is defined by the number of matched numbers, whether it includes a bonus match,
 * and the corresponding prize amount in KRW.
 */
enum class PrizeRank(val matchCount: Int, val hasBonus: Boolean, val prize: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        /**
         * Finds the appropriate prize rank based on the number of matches and bonus match status.
         */
        fun findByMatch(matchCount: Int, hasBonus: Boolean): PrizeRank {
            return when {
                matchCount == 6 -> PrizeRank.FIRST
                matchCount == 5 && hasBonus -> PrizeRank.SECOND
                matchCount == 4 -> PrizeRank.FOURTH
                matchCount == 5 -> PrizeRank.THIRD
                matchCount == 3 -> PrizeRank.FIFTH
                else -> PrizeRank.NONE
            }
        }
    }
}