package lotto.model

import lotto.constants.Descriptions
import lotto.constants.MatchCounts
import lotto.constants.Prize

enum class LottoRank(
    val prize: Int,
    val description: String
) {
    FIRST(Prize.FIRST, Descriptions.FIRST),
    SECOND(Prize.SECOND, Descriptions.SECOND),
    THIRD(Prize.THIRD, Descriptions.THIRD),
    FOURTH(Prize.FOURTH, Descriptions.FOURTH),
    FIFTH(Prize.FIFTH, Descriptions.FIFTH),
    NOTHING(Prize.NONE, Descriptions.NONE);

    companion object {
        fun fromMatchResult(matchCount: Int, matchBonus: Boolean): LottoRank {
            return when {
                matchCount == MatchCounts.SIX -> FIRST
                matchCount == MatchCounts.FIVE && matchBonus -> SECOND
                matchCount == MatchCounts.FIVE -> THIRD
                matchCount == MatchCounts.FOUR -> FOURTH
                matchCount == MatchCounts.THREE -> FIFTH
                else -> NOTHING
            }
        }
    }
}
