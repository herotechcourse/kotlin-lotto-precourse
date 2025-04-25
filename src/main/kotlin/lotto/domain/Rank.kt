package lotto.domain

enum class Rank(
    val matchCount: Int,
    val prize: Int,
    val matchBonus: Boolean = false
) {
    FIRST(RankConstants.MATCH_6, RankConstants.PRIZE_FIRST),
    SECOND(RankConstants.MATCH_5, RankConstants.PRIZE_SECOND, true),
    THIRD(RankConstants.MATCH_5, RankConstants.PRIZE_THIRD),
    FOURTH(RankConstants.MATCH_4, RankConstants.PRIZE_FOURTH),
    FIFTH(RankConstants.MATCH_3, RankConstants.PRIZE_FIFTH),
    NONE(RankConstants.MATCH_0, RankConstants.PRIZE_NONE);

    companion object {
        fun valueOf(matchCount: Int, matchBonus: Boolean): Rank {
            return when {
                matchCount == RankConstants.MATCH_6 -> FIRST
                matchCount == RankConstants.MATCH_5 && matchBonus -> SECOND
                matchCount == RankConstants.MATCH_5 -> THIRD
                matchCount == RankConstants.MATCH_4 -> FOURTH
                matchCount == RankConstants.MATCH_3 -> FIFTH
                else -> NONE
            }
        }
    }
}
