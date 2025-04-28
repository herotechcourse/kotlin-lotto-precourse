package lotto.domain

enum class LottoRank(val matchCount: Int, val prizeMoney: Int, val bonusRequired: Boolean = false) {
    MATCH_THREE(3, Settings.FIFTH_PRIZE),
    MATCH_FOUR(4, Settings.FOURTH_PRIZE),
    MATCH_FIVE(5, Settings.THIRD_PRIZE),
    MATCH_BONUS(5, Settings.SECOND_PRIZE),
    MATCH_SIX(6, Settings.FIRST_PRIZE);


    companion object {
        fun find(matchCount: Int, foundBonus: Boolean): LottoRank? {
            return when {
                matchCount == 6 -> MATCH_SIX
                matchCount == 5 && foundBonus -> MATCH_BONUS
                matchCount == 5 -> MATCH_FIVE
                matchCount == 4 -> MATCH_FOUR
                matchCount == 3 -> MATCH_THREE
                else -> null
            }
        }

    }

    fun displayName(): String {
        return when (this) {
            MATCH_THREE -> "3 Matches"
            MATCH_FOUR -> "4 Matches"
            MATCH_FIVE -> "5 Matches"
            MATCH_BONUS -> "5 Matches + Bonus Ball"
            MATCH_SIX -> "6 Matches"
        }
    }

}

