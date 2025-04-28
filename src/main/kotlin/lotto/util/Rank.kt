package lotto.util

enum class Rank(val matchCount: Int, val prize: Int) {
    FIFTH(3, 5_000),
    FORTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    companion object {
        fun updateRankCount(matchCount: Int, isBonusMatch: Boolean): Rank {
            return when {
                matchCount == 3 -> FIFTH
                matchCount == 4 -> FORTH
                matchCount == 5 && !isBonusMatch -> THIRD
                matchCount == 5 && isBonusMatch -> SECOND
                matchCount == 6 -> FIRST
                else -> NONE
            }
        }
    }

}