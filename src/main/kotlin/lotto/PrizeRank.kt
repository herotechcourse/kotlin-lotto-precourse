package lotto

enum class PrizeRank(val matchCount: Int, val requireBonus: Boolean, val prize: Int) {
    SIX_MATCH(6, false, 2_000_000_000),
    FIVE_MATCH_BONUS(5, true, 30_000_000),
    FIVE_MATCH(5, false, 1_500_000),
    FOUR_MATCH(4, false, 50_000),
    THREE_MATCH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): PrizeRank {
            return when {
                matchCount == 6 -> SIX_MATCH
                matchCount == 5 && matchBonus -> FIVE_MATCH_BONUS
                matchCount == 5 -> FIVE_MATCH
                matchCount == 4 -> FOUR_MATCH
                matchCount == 3 -> THREE_MATCH
                else -> NONE
            }
        }
    }
}
