package lotto.domain

enum class Rank(val matchCount: Int, val prizeMoney: Int, val bonusRequired: Boolean = false) {
    MATCH_THREE(3, lotto.FIFTH_PRIZE),
    MATCH_FOUR(4, lotto.FOURTH_PRIZE),
    MATCH_FIVE(5, lotto.THIRD_PRIZE),
    MATCH_BONUS(5, lotto.SECOND_PRIZE),
    MATCH_SIX(6, lotto.FIRST_PRIZE);


    companion object {
        fun find(matchCount: Int, foundBonus: Boolean): Rank? {
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

