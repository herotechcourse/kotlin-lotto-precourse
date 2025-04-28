package lotto.domain

/**
 * Represents the prize ranks, their match requirements, and prize amounts.
 */
enum class PrizeRank(
    val matchCount: Int,
    val requiresBonus: Boolean,
    val prize: Long
) {
    FIFTH(3, false, 5_000L),
    FOURTH(4, false, 50_000L),
    THIRD(5, false, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, false, 2_000_000_000L);

    companion object {
        /**
         * Determines rank by counting matches and whether bonus matched.
         */
        fun of(matchCount: Int, bonusMatch: Boolean): PrizeRank? =
            PrizeRank.entries.firstOrNull {
                it.matchCount == matchCount &&
                        it.requiresBonus == bonusMatch
            }
    }
}
