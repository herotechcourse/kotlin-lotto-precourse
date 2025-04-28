package lotto.model

enum class PrizeRank(val matches: Int, val prizeMoney: Int) {
    SIX_MATCH(6, 2_000_000_000),
    BONUS_MATCH(5, 30_000_000),
    FIVE_MATCH(5, 1_500_000),
    FOUR_MATCH(4, 50_000),
    THREE_MATCH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): PrizeRank {
            return when {
                matchCount == 6 -> SIX_MATCH
                matchCount == 5 && matchBonus -> BONUS_MATCH
                matchCount == 5 -> FIVE_MATCH
                matchCount == 4 -> FOUR_MATCH
                matchCount == 3 -> THREE_MATCH
                else -> NONE
            }
        }
    }
}