package lotto.util

enum class PrizeRank(
    val matchCount: Int,
    val requiresBonus: Boolean,
    val prizeMoney: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun determineRank(matchCount: Int, hasBonus: Boolean): PrizeRank =
            when (matchCount) {
                FIRST.matchCount -> FIRST
                SECOND.matchCount -> if (hasBonus) SECOND else THIRD
                THIRD.matchCount -> THIRD
                FOURTH.matchCount -> FOURTH
                FIFTH.matchCount -> FIFTH
                else -> NONE
            }
    }
}