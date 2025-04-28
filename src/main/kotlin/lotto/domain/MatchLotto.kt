package lotto.domain


enum class MatchLotto(val count: Int, val reward: Int, val description: String) {
    FIRST(MATCH_COUNT_SIX, 2_000_000_000, FIRST_DESCRIPTION),
    SECOND(MATCH_COUNT_FIVE, 30_000_000, SECOND_DESCRIPTION),
    THIRD(MATCH_COUNT_FIVE, 1_500_000, THIRD_DESCRIPTION),
    FOURTH(MATCH_COUNT_FOUR, 50_000, FOURTH_DESCRIPTION),
    FIFTH(MATCH_COUNT_THREE, 5_000, FIFTH_DESCRIPTION),
    NONE(MATCH_COUNT_ZERO, 0, NONE_DESCRIPTION);

    companion object {
        fun from(matched: Int, bonusMatched: Boolean): MatchLotto {
            return when {
                matched == MATCH_COUNT_SIX -> FIRST
                matched == MATCH_COUNT_FIVE && bonusMatched -> SECOND
                matched == MATCH_COUNT_FIVE -> THIRD
                matched == MATCH_COUNT_FOUR -> FOURTH
                matched == MATCH_COUNT_THREE -> FIFTH
                else -> NONE
            }
        }
    }
}

const val MATCH_COUNT_SIX = 6
const val MATCH_COUNT_FIVE = 5
const val MATCH_COUNT_FOUR = 4
const val MATCH_COUNT_THREE = 3
const val MATCH_COUNT_ZERO = 0

const val FIRST_DESCRIPTION = "6 Matches"
const val SECOND_DESCRIPTION = "5 Matches + Bonus Ball"
const val THIRD_DESCRIPTION = "5 Matches"
const val FOURTH_DESCRIPTION = "4 Matches"
const val FIFTH_DESCRIPTION = "3 Matches"
const val NONE_DESCRIPTION = ""
