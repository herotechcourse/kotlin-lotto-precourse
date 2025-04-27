package lotto.domain

enum class Rank(val matchCount: Int, val prizeMoney: Int, val bonusRequired: Boolean = false) {
    MATCH_SIX(6, 2_000_000_000),
    MATCH_BONUS(5, 30_000_000),
    MATCH_FIVE(5, 1_500_000),
    MATCH_FOUR(4, 50_000),
    MATCH_THREE(3, 5_000);


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

}

